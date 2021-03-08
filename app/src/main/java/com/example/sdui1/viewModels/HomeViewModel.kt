package com.example.sdui1.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.sdui1.Home
import com.example.sdui1.HomeUpdate
import kotlin.reflect.KFunction0

class HomeViewModel: ViewModel() {

    val updateQuery= liveData {
            emit(HomeUpdate.getPaged())
    }

    val query= liveData {
            emit(Home.getPaged())
    }
}


