package com.example.vydya_app

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AboutMeInner(){
    var name by remember{ mutableStateOf("") }
    var age by remember{mutableStateOf("")}
    var gender by remember{ mutableStateOf("") }
    var phone by remember{ mutableStateOf("") }
    var address by remember{ mutableStateOf("") }
    Column(modifier= Modifier.fillMaxSize().background(color= Color.White)) {
        Column(modifier=Modifier.fillMaxWidth(),verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.about),
                contentDescription = "Human logo"
            )
            Text(text = "About Me")

        }
        Column(modifier=Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){
            MyTextField(labelValue = "Name", painterResource (id=R.drawable.user), value = name, onValueChange ={name=it} )
            MyTextField(labelValue ="Age" , painterResource (id=R.drawable.age), value = age, onValueChange ={age=it} )
            MyTextField(labelValue = "Gender", painterResource (id=R.drawable.gender), value =gender , onValueChange = {gender=it})
            MyTextField(labelValue = "Phone Number", painterResource(id=R.drawable.phone) , value = phone, onValueChange = {phone=it})
            MyTextField(labelValue = "Address", painterResource (R.drawable.address), value =address  , onValueChange ={address=it} )
            Spacer(modifier=Modifier.heightIn(20.dp))
            Button(onClick = {  }, modifier= Modifier
                .fillMaxWidth()
                .heightIn(48.dp),
                contentPadding= PaddingValues(),
                colors= ButtonDefaults.buttonColors(Color.Transparent)) {
                Box(modifier= Modifier
                    .fillMaxWidth(0.5f)
                    .heightIn(48.dp)
                    .background(
                        color=Color(0xFFE1E587),
                        shape = RoundedCornerShape(10.dp)
                    ), contentAlignment = Alignment.Center

                ) {
                    Text(
                        text = "Submit",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color=Color.Black
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun hospPreview(){
    AboutMeInner()
}