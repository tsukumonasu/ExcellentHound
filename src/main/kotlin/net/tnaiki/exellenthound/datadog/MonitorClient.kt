package net.tnaiki.exellenthound.datadog

import com.google.gson.Gson
import link.webarata3.kexcelapi.KExcel
import link.webarata3.kexcelapi.set
import net.tnaiki.exellenthound.json.monitor.MonitorResponse
import org.apache.poi.ss.usermodel.CellStyle
import org.apache.poi.ss.usermodel.Sheet
import org.yaml.snakeyaml.Yaml
import java.io.File
import java.io.FileInputStream

class MonitorClient @JvmOverloads constructor(
        override var rowList: List<MonitorResponse> = arrayListOf()) : AbstractClient() {

    override fun getJson() {
        val url = "https://app.datadoghq.com/api/v1/" + apiUrl +
                "?&api_key=" + apiKey + "&application_key=" + applicationKey
        val monitorList = Gson().fromJson(getBody(url), Array<MonitorResponse>::class.java)
        rowList = monitorList.toList()
    }

    override fun output() {
        KExcel.open("./template/$apiUrl.xlsx").use { workbook ->
            val values = Yaml().load(FileInputStream(File("./conf/hound.yaml"))) as Map<*, *>
            setSheetValue(workbook.getSheet(apiUrl), values[apiUrl] as Map<*, *>, Integer.parseInt(values["startRowIndex"].toString()))
            KExcel.write(workbook, "${excelTitle}_$apiUrl.xlsx")
        }
    }

    override fun setSheetValue(sheet: Sheet, map: Map<*, *>, startRowIndex: Int, styleList: List<CellStyle>) {
        var rowIndex = startRowIndex
        rowList.forEach { monitor ->
            sheet[map["creator"].toString() + rowIndex] = getExcelString32768(monitor.creator)
            sheet[map["created"].toString() + rowIndex] = monitor.created
            sheet[map["query"].toString() + rowIndex] = monitor.query
            sheet[map["matchingDowntimes"].toString() + rowIndex] = getExcelString32768(monitor.matchingDowntimes)
            sheet[map["createdAt"].toString() + rowIndex] = getExcelString32768(monitor.createdAt)
            sheet[map["overallState"].toString() + rowIndex] = getExcelString32768(monitor.overallState)
            sheet[map["message"].toString() + rowIndex] = monitor.message
            sheet[map["type"].toString() + rowIndex] = monitor.type
            sheet[map["tags"].toString() + rowIndex] = getExcelString32768(monitor.tags)
            sheet[map["multi"].toString() + rowIndex] = monitor.isMulti
            sheet[map["deleted"].toString() + rowIndex] = getExcelString32768(monitor.deleted)
            sheet[map["overallStateModified"].toString() + rowIndex] = getExcelString32768(monitor.overallStateModified)
            sheet[map["orgId"].toString() + rowIndex] = monitor.orgId
            sheet[map["name"].toString() + rowIndex] = monitor.name
            sheet[map["options"].toString() + rowIndex] = getExcelString32768(monitor.options)
            sheet[map["modified"].toString() + rowIndex] = monitor.modified
            sheet[map["id"].toString() + rowIndex] = monitor.id
            rowIndex++
        }
    }
}