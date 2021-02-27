package com.example.sdui1.network


import com.example.sdui1.data.ContactPage.ContactPage
import com.example.sdui1.data.HomePage.HomePage
import retrofit2.http.GET


interface ApiRequests {
    @GET("/1")
    suspend fun getPageModel(): HomePage

    @GET("/2")
    suspend fun getPageModel1(): ContactPage

}

