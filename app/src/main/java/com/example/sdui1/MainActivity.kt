package com.example.sdui1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.setContent
import androidx.lifecycle.ViewModelProvider
import com.example.sdui1.composeModels.Homepage
import com.example.sdui1.composeModels.Contactpage
import com.example.sdui1.viewModels.HomeViewModel
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sdui1.viewModels.ContactViewModel

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            AppNavigator(this)
        }
    }
}
@Composable
fun AppNavigator(obj:MainActivity){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "HomePage"){
        composable("HomePage"){
            val mHomeViewModel by lazy {
                ViewModelProvider(obj)
                        .get(HomeViewModel::class.java)
            }
            Greet(mHomeViewModel,navController)
        }
        composable("text"){
            val ContactViewModel by lazy {
                ViewModelProvider(obj)
                        .get(ContactViewModel::class.java)
            }
            Contact(ContactViewModel,navController)
        }
    }


}
@Composable
fun Greet(page:HomeViewModel, navController: NavHostController?){
    val pages by page.repoQuery.observeAsState()
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
//      JetpackCompose(child =pages!!.child )
    }
}
@Composable
fun Contact(page:ContactViewModel, navController: NavHostController?){
    val pages by page.repoQuery.observeAsState()
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

        Contactpage(child = pages!!.child, navController = navController)
    }
}