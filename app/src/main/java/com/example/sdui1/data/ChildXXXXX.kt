package com.example.sdui1.data


import com.google.gson.annotations.SerializedName

data class ChildXXXXX(
    val child: List<ChildXXXXXX>,
    val component: String,
    val fontWeight: String,
    val horizontalPadding: Int,
    val text: String,
    val verticalPadding: Int
)