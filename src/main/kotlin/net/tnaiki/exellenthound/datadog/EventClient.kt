package net.tnaiki.exellenthound.datadog

import com.google.gson.Gson
import link.webarata3.kexcelapi.KExcel
import link.webarata3.kexcelapi.get
import link.webarata3.kexcelapi.set
import net.tnaiki.exellenthound.json.events.EventsItem
import net.tnaiki.exellenthound.json.events.EventsResponse
import org.apache.poi.ss.usermodel.CellStyle
import org.apache.poi.ss.usermodel.Sheet
import org.yaml.snakeyaml.Yaml
import java.io.File
import java.io.FileInputStream
import java.util.Date

class EventClient @JvmOverloads constructor(
        override var rowList: List<EventsItem> = arrayListOf()) : AbstractClient() {

    override fun getJson() {
        val url = "https://app.datadoghq.com/api/v1/" + apiUrl +
                "?&api_key=" + apiKey + "&application_key=" + applicationKey
        val start = "&start=" + getUnixtime(System.getenv("START_DATE"))
        val end = "&end=" + getUnixtime(System.getenv("END_DATE"))
        rowList += Gson().fromJson(getBody(url + start + end), EventsResponse::class.java).events
        arrayListOf(rowList)
    }

    override fun output() {
        KExcel.open("./template/$apiUrl.xlsx").use { workbook ->
            val values = Yaml().load(FileInputStream(File("./conf/hound.yaml"))) as Map<*, *>
            val style = workbook.createCellStyle()
            style.dataFormat = workbook.createDataFormat().getFormat(dateFormat)
            setSheetValue(workbook.getSheet(apiUrl), values[apiUrl] as Map<*, *>, Integer.parseInt(values["startRowIndex"].toString()), arrayListOf(style))
            KExcel.write(workbook, "${excelTitle}_$apiUrl.xlsx")
        }
    }

    override fun setSheetValue(sheet: Sheet, map: Map<*, *>, startRowIndex: Int, styleList: List<CellStyle>) {
        var rowIndex = startRowIndex
        rowList.forEach { event ->
            sheet[map["aggregate"].toString() + rowIndex] = getExcelString32768(event.isIsAggregate)
            sheet[map["comments"].toString() + rowIndex] = getExcelString32768(event.comments)
            sheet[map["resource"].toString() + rowIndex] = event.resource
            sheet[map["source"].toString() + rowIndex] = event.source
            sheet[map["title"].toString() + rowIndex] = event.title
            sheet[map["priority"].toString() + rowIndex] = event.priority
            sheet[map["alertType"].toString() + rowIndex] = getExcelString32768(event.alertType)
            sheet[map["url"].toString() + rowIndex] = event.url
            sheet[map["tags"].toString() + rowIndex] = getExcelString32768(event.tags)
            sheet[map["deviceName"].toString() + rowIndex] = getExcelString32768(event.deviceName)
            sheet[map["children"].toString() + rowIndex] = getExcelString32768(event.children)
            sheet[map["host"].toString() + rowIndex] = getExcelString32768(event.host)
            sheet[map["text"].toString() + rowIndex] = getExcelString32768(event.text)
            sheet[map["id"].toString() + rowIndex] = getExcelString32768(event.id)
            sheet[map["dateHappened"].toString() + rowIndex] = getExcelString32768(event.dateHappened)
            sheet[map["date"].toString() + rowIndex] = Date(event.dateHappened * 1000)
            sheet[map["date"].toString() + rowIndex].cellStyle = styleList[0]
            rowIndex++
        }
    }
}