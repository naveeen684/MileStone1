package com.example.sdui1.network


import com.example.sdui1.data.HomePage
import retrofit2.http.GET


interface ApiRequests {
    @GET("/")
    suspend fun getPageModel(): HomePage

}

