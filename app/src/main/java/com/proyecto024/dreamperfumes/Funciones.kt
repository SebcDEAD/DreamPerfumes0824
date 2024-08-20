package com.proyecto024.dreamperfumes

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
import java.net.URLEncoder

class Funciones {

    companion object {
        const val dirWebSer: String = "https://api-chi-drab.vercel.app/api/accion=validar"

        fun validar(username: String, password: String, callback: (String?) -> Unit) {
            CoroutineScope(Dispatchers.IO).launch {
                val client = OkHttpClient()
                val url = "$dirWebSer?accion=validar&username=${URLEncoder.encode(username, "UTF-8")}&password=${URLEncoder.encode(password, "UTF-8")}"

                println("URL: $url")  // Log para depuración

                val request = Request.Builder()
                    .url(url)
                    .build()

                try {
                    val response = client.newCall(request).execute()
                    if (!response.isSuccessful) throw IOException("Unexpected code ${response.code}")
                    val responseBody = response.body?.string()
                    withContext(Dispatchers.Main) {
                        callback(responseBody)
                    }
                } catch (e: Exception) {
                    withContext(Dispatchers.Main) {
                        callback(null)
                    }
                }
            }
        }
    }
}
