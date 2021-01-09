package com.example.sdui1.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitClient {
//    private const val BASE_URL = "http://127.0.0.1:8000/"
    private const val BASE_URL = "https://subset.free.beeceptor.com/"


    private val client: OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(100, TimeUnit.SECONDS)
        .readTimeout(100, TimeUnit.SECONDS).build()

    val service: ApiRequests = Retrofit.Builder()
        .baseUrl(BASE_URL).client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiRequests::class.java)
}