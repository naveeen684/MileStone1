package com.example.sdui1.data


import com.google.gson.annotations.SerializedName

data class ChildXXXXXX(
    val child: List<ChildXXXXXXX>,
    val clickable: String,
    val component: String,
    val height: Int,
    val name: String,
    val padding: Int,
    val width: Int
)