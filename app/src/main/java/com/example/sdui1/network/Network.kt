package com.example.sdui1.network


import com.example.sdui1.data.SettingsPage.SettingsPage
import com.example.sdui1.data.HomePage.HomePage
import retrofit2.http.GET


interface ApiRequests {
    @GET("/1")
    suspend fun getPageModel(): HomePage

    @GET("/new1")
    suspend fun getPageUpdateModel(): HomePage

    @GET("/2")
    suspend fun getPageModel1(): SettingsPage

    @GET("/new2")
    suspend fun getPageUpdateModel1(): SettingsPage

}
