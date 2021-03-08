package com.example.sdui1.composeModels

import android.net.Uri
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.material.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.sdui1.data.HomePage.*
import com.example.sdui1.utils.DEFAULT_RECIPE_IMAGE
import com.example.sdui1.utils.loadPicture



@Composable
fun getColor(color:String): Color {
    if(color=="White"){
        return Color.White
    }
    else{
        return Color.Gray
    }
}



@Composable
fun Homepage(child: List<Child>,navController: NavHostController?) {
    Scaffold(
        bodyContent = {
            BodyContent(child = child[0].child[0].child,navController)
        }
    )
}

@Composable
fun BodyContent(child: List<ChildXX>,navController: NavHostController?){
    Surface(color= Color(red=child[0].color[0],green =child[0].color[1],blue = child[0].color[2] ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(child[0].child[0].padding.dp)) {
            Spacer(modifier = Modifier.padding(vertical = child[0].child[0].child[0].verticalPadding.dp))
            ScrollableColumn() {
                for(element in child[0].child[0].child[1].child){
                    if(element.component=="Surface") {
                        Corousal(child = element,navController)
                    }
                    else if(element.component=="Spacer") {
                        Spacer(modifier = Modifier.padding(vertical = element.verticalPadding.dp))
                    }
                }
            }
        }
    }

}



@Composable
fun Corousal(child: ChildXXXXX,navController: NavHostController?) {
    Surface(color = getColor(child.color)) {
        Column() {
            Spacer(modifier = Modifier.padding(vertical = child.child[0].child[0].verticalPadding.dp))
            if(child.child[0].child[1].text!=null) {
                Text(
                    child.child[0].child[1].text,
                    modifier = Modifier.padding(horizontal = child.child[0].child[1].horizontalPadding.dp),
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
            }
//            Log.d("Hi",child.child[1].component)
            if(child.child[1].id==1) {
                RowTemplate(child = child.child[1],navController)
            }
            else if(child.child[1].id==2){
                RowTemplate1(child = child.child[1],navController)
            }
            else if(child.child[1].id==3) {
                RowTemplate(child = child.child[1],navController)
            }
            else{
                RowTemplate1(child = child.child[1],navController)
            }

        }
    }
}



@Composable
fun RowTemplate1(child: ChildXXXXXX,navController: NavHostController?){

    for(element in child.child) {
        Row() {
            for (element in element.child) {
                CardTemplate(child = element){
                    navController?.navigate(element.clickable)
                }
            }
        }
    }

}

@Composable
fun RowTemplate(child: ChildXXXXXX, navController: NavHostController?){
    Row(){
        ScrollableRow() {
            for(element in child.child[0].child) {
                CardTemplate(child = element){
                    navController?.navigate(element.clickable)
                }
            }
        }
    }
}

@Composable
fun CardTemplate(child: ChildXXXXXXXX,clickAction:() ->Unit) {
    Card(modifier = Modifier.height(child.height.dp).width(child.width.dp).padding(child.padding.dp).clickable(onClick = {
        clickAction.invoke()
    })) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.padding(vertical = 8.dp))
            val image = loadPicture(url =child.child[0].child[0].id , defaultImage =DEFAULT_RECIPE_IMAGE ).value
            image?.let { img ->
                Image(
                    bitmap = img.asImageBitmap(),
                    modifier = Modifier.height(child.child[0].child[0].height.dp).width(child.child[0].child[0].width.dp)
                )
            }

            Spacer(modifier = Modifier.padding(vertical = child.child[0].child[1].verticalPadding.dp))
            Text(text = child.child[0].child[2].text,style=TextStyle(textAlign = TextAlign.Center))
        }

    }

}