package kg.twnscake.twinscaketest.presentation.extensions

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kg.proverbs.baet.presentation.extensions.toast
import java.io.IOException

inline fun <reified T> Context.jsonFromAssetsList(fileName: String): List<T> {
    lateinit var jsonString: String
    try {
        jsonString = assets.open(fileName)
            .bufferedReader()
            .use { it.readText() }
    } catch (ioException: IOException) {
        toast(ioException.localizedMessage ?: "Произошла ошибка")
    }

    val listOfContent = object : TypeToken<List<T>>() {}.type
    return Gson().fromJson(jsonString, listOfContent)
}

inline fun <reified T> Context.jsonFromAssetString(fileName: String): T {
    lateinit var jsonString: String
    try {
        jsonString = assets.open(fileName)
            .bufferedReader()
            .use { it.readText() }
    } catch (ioException: IOException) {
        toast(ioException.localizedMessage ?: "Произошла ошибка")
    }

    val listOfContent = object : TypeToken<T>() {}.type
    return Gson().fromJson(jsonString, listOfContent)
}