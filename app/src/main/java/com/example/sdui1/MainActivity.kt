package com.example.sdui1

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.setContent
import androidx.lifecycle.ViewModelProvider
import com.example.sdui1.composeModels.Homepage
import com.example.sdui1.viewModels.HomeViewModel
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sdui1.composeModels.Settingspage
import com.example.sdui1.data.SettingsPage.SettingsPage
import com.example.sdui1.data.HomePage.HomePage
import com.example.sdui1.viewModels.SettingsViewModel

class MainActivity : AppCompatActivity() {
    var upd=false;
    private fun saveData(update:Boolean){
        val sharedPreferences=getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.apply{
            putBoolean("UPDATE_KEY",update)
        }.apply()
    }

    private fun loadData(): Boolean {
        val sharedPreferences=getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean("UPDATE_KEY",false)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        upd=loadData()
        setContent {
            AppNavigator(this,upd,this::saveData,this::loadData)
        }
    }
}


@Composable
fun AppNavigator(
    obj:MainActivity,
    upd:Boolean,
    saveData:(update:Boolean)->Unit,
    loadData: ()->Boolean
){
    val update = remember { mutableStateOf(upd)}
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "1"){
        composable("1"){

            val homeViewModel by lazy {
                    ViewModelProvider(obj)
                        .get(HomeViewModel::class.java)
            }
            if(loadData()) {
                val pages by homeViewModel.updateQuery.observeAsState()
                Home(navController = navController,pages)
            }
            else{
                val pages by homeViewModel.query.observeAsState()
                Home(navController = navController,pages)
            }
        }
        composable("2"){
            val settingsViewModel by lazy {
                ViewModelProvider(obj)
                        .get(SettingsViewModel::class.java)
            }
            val pages by settingsViewModel.query.observeAsState()
            Settings(update,navController,saveData,pages)
        }

        composable("0"){
            Default()
        }
    }


}
@Composable
fun Home(navController: NavHostController?,pages:HomePage?){

    if(pages==null){
        Column(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                imageResource(id = R.drawable.load),
                modifier = Modifier.height(60.dp).width(60.dp)
            )
        }
    }
    else{
        Homepage(child =pages!!.child,navController)
    }
}
@Composable
fun Settings(update:MutableState<Boolean>, navController: NavHostController?, saveData:(update:Boolean)->Unit,pages:SettingsPage?){
    if(pages==null){
        Column(
                modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                    imageResource(id = R.drawable.load),
                    modifier = Modifier.height(60.dp).width(60.dp)
            )
        }
    }
    else{
        Settingspage(update=update,child = pages!!.child, navController = navController,saveData)
    }
}

@Composable
fun Default(){
    Column(modifier = Modifier.fillMaxWidth().fillMaxHeight(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Not Available!",style = TextStyle(fontWeight = FontWeight.Bold))
    }
}