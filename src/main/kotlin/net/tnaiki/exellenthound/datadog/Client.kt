package net.tnaiki.exellenthound.datadog

import okhttp3.OkHttpClient
import okhttp3.Request
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.CellStyle
import java.text.SimpleDateFormat


interface IClient {
    fun getJson()
    fun output()
}

abstract class AbstractClient(
        private val httpClient: OkHttpClient = OkHttpClient(),
        val applicationKey: String = System.getenv("DATADOG_APP_KEY"),
        val apiKey: String = System.getenv("DATADOG_API_KEY"),
        val apiUrl: String = System.getenv("DATADOG_API"),
        val excelTitle: String = System.getenv("EXELE_FILE_TITLE")) : IClient {

    abstract val rowList: List<Any>

    fun getBody(url: String): String {
        val request = Request.Builder().url(url).build()
        httpClient.newCall(request).execute().use { response -> return response.body()!!.string() }
    }

    abstract override fun getJson()
    abstract override fun output()
    abstract fun setSheetValue(sheet: Sheet, map: Map<*, *>, startRowIndex: Int, styleList: List<CellStyle> = arrayListOf())

    val dateFormat = "yyyy/MM/dd hh:mm:ss"

    fun getUnixtime(strDate: String): Long {
        return SimpleDateFormat(dateFormat).parse(strDate).time / 1000L
    }

    fun getExcelString32768(target: Any?): String {
        val result = target?.toString() ?: ""
        if (result.length <= 32768) {
            return result
        }
        return result.substring(0, 32767)
    }
}

fun main(args: Array<String>) {
    fun getClient(): IClient {
        if (System.getenv("DATADOG_API") == "events") return EventClient()
        return MonitorClient()
    }
    val client: IClient = getClient()
    client.getJson()
    client.output()
}