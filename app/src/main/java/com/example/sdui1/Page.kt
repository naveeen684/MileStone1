package com.example.sdui1

import com.example.sdui1.data.SettingsPage.SettingsPage
import com.example.sdui1.data.HomePage.HomePage
import com.example.sdui1.network.RetrofitClient

object Home{
    suspend fun getPaged(): HomePage {
        return RetrofitClient.service.getPageModel()
    }
}

object HomeUpdate{
    suspend fun getPaged(): HomePage {
        return RetrofitClient.service.getPageUpdateModel()
    }
}


object Contact{
    suspend fun getPaged(): SettingsPage {
        return RetrofitClient.service.getPageModel1()
    }
}

object ContactUpdate{
    suspend fun getPaged(): SettingsPage {
        return RetrofitClient.service.getPageUpdateModel1()
    }
}