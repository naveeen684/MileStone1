package com.example.sdui1.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.sdui1.Contact

class SettingsViewModel(): ViewModel() {
    val query= liveData {
        emit(Contact.getPaged())
    }
}
