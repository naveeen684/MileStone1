package com.example.sdui1.data


import com.google.gson.annotations.SerializedName

data class ChildXXXXXXX(
    val child: List<ChildXXXXXXXX>,
    val component: String,
    val fontWeight: String,
    val horizontalPadding: Int,
    val text: String,
    val verticalPadding: Int
)