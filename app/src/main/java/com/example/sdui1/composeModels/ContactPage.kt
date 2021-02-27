package com.example.sdui1.composeModels

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.sdui1.data.ContactPage.Child


@Composable
fun Contactpage(child: List<Child>, navController: NavHostController?) {
    Scaffold(
            bodyContent = {
                Text(child[0].child[1].text)
            }
    )
}