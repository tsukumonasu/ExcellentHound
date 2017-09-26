package net.tnaiki.exellenthound.datadog

import java.io.IOException
import okhttp3.OkHttpClient
import okhttp3.Request
import com.google.gson.Gson
import link.webarata3.kexcelapi.*
import net.tnaiki.exellenthound.json.events.EventsItem
import net.tnaiki.exellenthound.json.events.EventsResponse
import net.tnaiki.exellenthound.json.monitor.MonitorResponse
import org.apache.poi.ss.usermodel.Sheet
import java.io.File
import java.io.FileInputStream
import org.yaml.snakeyaml.Yaml
import java.util.*
import org.apache.poi.ss.usermodel.CellStyle


class Client @JvmOverloads constructor(
        private var application_key: String = System.getenv("DATADOG_APP_KEY"),
        private var httpClient: OkHttpClient = OkHttpClient(),
        private var apiKey: String = System.getenv("DATADOG_API_KEY"),
        private var apiUrl: String = System.getenv("DATADOG_API"),
        private var excelTitle: String = System.getenv("EXELE_FILE_TITLE"),
        private var monitorList: Array<MonitorResponse> = arrayOf(),
        private var eventList: List<EventsItem> = arrayListOf()) {

    @Throws(IOException::class)
    private fun getBody(url: String): String {
        val request = Request.Builder().url(url).build()
        httpClient.newCall(request).execute().use { response -> return response.body()!!.string() }
    }

    private fun getGson() {
        val url = "https://app.datadoghq.com/api/v1/" + apiUrl +
                "?&api_key=" + apiKey + "&application_key=" + application_key
        val unixTime = System.currentTimeMillis() / 1000L
        if (apiUrl == "events") {
            for (i in 1..Integer.parseInt(System.getenv("DATADOG_EVENT_DAYS"))) {

                val start = "&start=" + (unixTime - i * 3600 * 24)
                val end = "&end=" + (unixTime - (i - 1) * 3600 * 24)

                eventList += Gson().fromJson(getBody(url + start + end), EventsResponse::class.java).events
            }
        } else {
            monitorList = Gson().fromJson(getBody(url), Array<MonitorResponse>::class.java)
        }
    }

    private fun output() {
        KExcel.open("./template/$apiUrl.xlsx").use { workbook ->
            val values = Yaml().load(FileInputStream(File("./conf/hound.yaml"))) as Map<*, *>
            if (this.apiUrl == "events") {
                val style = workbook.createCellStyle()
                style.dataFormat = workbook.createDataFormat().getFormat("yyyy/mm/dd hh:mm:ss")
                setEventsValue(workbook.getSheet(apiUrl), values[apiUrl] as Map<*, *>, Integer.parseInt(values["startRowIndex"].toString()), style)
            } else {
                setMonitorValue(workbook.getSheet(apiUrl), values[apiUrl] as Map<*, *>, Integer.parseInt(values["startRowIndex"].toString()))
            }
            KExcel.write(workbook, "${excelTitle}_$apiUrl.xlsx")
        }
    }

    private fun setMonitorValue(sheet: Sheet, map: Map<*, *>, startRowIndex: Int) {
        var rowIndex = startRowIndex
        monitorList.forEach { monitor ->
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

    private fun setEventsValue(sheet: Sheet, map: Map<*, *>, startRowIndex: Int, style: CellStyle) {
        var rowIndex = startRowIndex
        eventList.forEach { event ->
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
            sheet[map["date"].toString() + rowIndex].cellStyle = style
            rowIndex++

        }
    }

    private fun getExcelString32768(target: Any?): String {
        val result = target?.toString() ?: ""
        if (result.length <= 32768) {
            return result
        }
        return result.substring(0, 32767)
    }

    companion object {
        @Throws(IOException::class)
        @JvmStatic
        fun main(args: Array<String>) {
            val client = Client()
            client.getGson()
            client.output()
        }
    }
}
