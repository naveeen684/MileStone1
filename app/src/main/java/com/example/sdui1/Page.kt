package com.example.sdui1

import com.example.sdui1.data.HomePage.HomePage
import com.example.sdui1.network.RetrofitClient

object Page{
    suspend fun getPaged(): HomePage {
        return RetrofitClient.service.getPageModel()
    }
}