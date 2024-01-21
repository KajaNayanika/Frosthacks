package com.example.vydya_app

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun Hospital(navController: NavController){
    Column(modifier= Modifier
        .fillMaxSize()
        .padding(10.dp)
        .background(color = Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Row(modifier=Modifier.padding(10.dp)){
            Column() {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.padding(horizontal = 7.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.hosp),
                        contentDescription = "hospital logo",
                        modifier = Modifier.size(100.dp).clickable{
                            navController.navigate("hospInnerPage")
                        }
                    )
                }
                    Text(text = "Hospitals near me")
                }

            Spacer(modifier=Modifier.widthIn(20.dp))
            Column(){
                Image(painter = painterResource(id = R.drawable.doc) , contentDescription ="Doctors logo",
                    modifier=Modifier.size(100.dp))

                Text(text="Doctors near me")
            }
        }
        Row(modifier=Modifier.padding(10.dp)){
            Column(){
                Box(contentAlignment = Alignment.Center,
                    modifier = Modifier.padding(horizontal = 7.dp)) {
                    Image(painter = painterResource(id = R.drawable.medicine),
                        contentDescription = "medicines picture",
                        modifier = Modifier.size(100.dp).clickable {
                            navController.navigate("")
                        })
                }

                Text(text="Pharmacy near me")
            }
            Spacer(modifier=Modifier.widthIn(20.dp))
            Column(){
                Image(painter = painterResource(id = R.drawable.about) ,
                    contentDescription ="Human Icon" ,
                    modifier=Modifier.size(100.dp).clickable{
                        navController.navigate("AboutMe")
                    })
                    Box(contentAlignment=Alignment.Center,
                        modifier = Modifier.padding(horizontal = 20.dp)) {
                        Text(
                            text = "About Me"
                        )
                    }
            }
        }

    }
}

@Preview
@Composable
fun HospitalPreview(){
    //Hospital()
}

