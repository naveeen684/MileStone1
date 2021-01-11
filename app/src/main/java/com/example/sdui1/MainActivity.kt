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
import com.example.sdui1.ComposeModels.Homepage
import com.example.sdui1.viewmodels.HomeViewModel
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp

class MainActivity : AppCompatActivity() {

        private val mHomeViewModel by lazy {
            ViewModelProvider(this@MainActivity)
                    .get(HomeViewModel::class.java)
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            Greet(mHomeViewModel)
        }
    }
}

@Composable
fun Greet(page:HomeViewModel){
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
        Homepage(child =pages!!.child)
//      JetpackCompose(child =pages!!.child )
    }
}