package com.example.sdui1.data.ContactPage


import com.google.gson.annotations.SerializedName

data class ContactPage(
    val child: List<Child>,
    val id: Int,
    val screen: String
)