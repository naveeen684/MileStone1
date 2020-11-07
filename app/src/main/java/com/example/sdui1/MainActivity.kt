package com.example.sdui1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.foundation.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.setContent
import androidx.lifecycle.ViewModelProvider
import com.example.sdui1.ComposeModels.Homepage
import com.example.sdui1.viewmodels.HomeViewModel

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
        Text(text = "Loading")
    }
    else{
        Homepage(child =pages!!.child)
//      JetpackCompose(child =pages!!.child )
    }
}