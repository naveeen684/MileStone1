package com.example.sdui1.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.sdui1.Page

class HomeViewModel: ViewModel() {
    val repoQuery= liveData {
        emit(Page.getPaged())
    }
}