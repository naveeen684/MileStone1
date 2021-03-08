package com.example.sdui1.composeModels

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import com.example.sdui1.data.SettingsPage.Child

@Composable
fun Settingspage(update: MutableState<Boolean>, child: List<Child>, navController: NavHostController?,saveData:(update:Boolean)->Unit) {
    Scaffold(
            bodyContent = {
                Column(modifier = Modifier.fillMaxWidth().fillMaxHeight(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = "Version Control",style = TextStyle(fontWeight = FontWeight.Bold))
                    Switch(
                            checked = update.value,
                            onCheckedChange = {
                                checked->update.value=checked
                                saveData(update.value)

                            }
                    )
                }

            }
    )
}