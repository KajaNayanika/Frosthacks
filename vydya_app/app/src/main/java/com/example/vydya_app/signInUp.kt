package com.example.vydya_app

import androidx.compose.foundation.background
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun signInUp(navController: NavController){

    Box(contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
            .background(color= Color(0xFF2B4B3E))) {
        Column(modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "VYDYA",fontSize=40.sp, fontFamily= FontFamily.SansSerif,
                color=Color(0xFF72b879))
            Spacer(modifier=Modifier.heightIn(25.dp))

            Button(onClick = { navController.navigate("homePage") }, modifier= Modifier
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
                        text = "Log In",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color=Color.Black
                    )
                }
            }
                    Spacer(modifier=Modifier.heightIn(16.dp))
            Button(onClick = { navController.navigate("signUp") }, modifier= Modifier
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
                        text = "Sign Up",
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
fun signPreview(){
   // signInUp()
}
