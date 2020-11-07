package com.example.sdui1.ComposeModels

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.sdui1.R
import com.example.sdui1.data.*


@Composable
fun Homepage(child: List<Child>) {
    Scaffold(
            bodyContent = {
                bodyContent(child = child)
            }
    ) 
}

@Composable
fun bodyContent(child: List<Child>){
    Surface(color= Color(red=child[0].color[0],green =child[0].color[1],blue = child[0].color[2] ),
            modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(child[0].child[0].padding.dp)) {
            Spacer(modifier = Modifier.padding(vertical = child[0].child[0].child[0].verticalPadding.dp))
            ScrollableColumn() {
                Corousal(child = child[0].child[0].child[1].child[0])
            }
        }
    }
}



@Composable
fun Corousal(child: ChildXXX) {
    Surface(color = Color.White) {
        Column() {
            Spacer(modifier = Modifier.padding(vertical = child.child[0].child[0].verticalPadding.dp))
            Text(
                "Money Transfers",
                modifier = Modifier.padding(horizontal = child.child[0].child[1].horizontalPadding.dp),
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
            RowTemplate(child = child.child[1])

        }
    }
}

@Composable
fun RowTemplate(child: ChildXXXX){
    Row(){
        ScrollableRow() {
            for(element in child.child[0].child) {
                CardTemplate(child = element)
            }
        }
    }
}

@Composable
fun CardTemplate(child: ChildXXXXXX) {
    Card(modifier = Modifier.height(child.height.dp).width(child.width.dp).padding(child.padding.dp).clickable(onClick = {})) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                imageResource(id = R.drawable.coin),
                modifier = Modifier.height(child.child[0].child[0].height.dp).width(child.child[0].child[0].width.dp)
            )
            Spacer(modifier = Modifier.padding(vertical = child.child[0].child[1].verticalPadding.dp))
            Text(text = child.child[0].child[2].text)
        }

    }

}
