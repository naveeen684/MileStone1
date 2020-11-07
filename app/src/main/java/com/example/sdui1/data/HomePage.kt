package com.example.sdui1.data


import com.google.gson.annotations.SerializedName

data class HomePage(
    val child: List<Child>,
    val id: Int,
    val screen: String
)