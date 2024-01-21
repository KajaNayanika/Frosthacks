package com.example.vydya_app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
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
import androidx.navigation.NavController

@Composable
fun signUpPage(onNavigate:()->Unit,navController:NavController){
    Box(modifier= Modifier
        .fillMaxSize()
        .background(color = Color(0xFFB6B971))
        , contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement= Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text="Sign Up",color= Color(0xFF1D5B23),fontSize=25.sp,
                modifier= Modifier.padding(top = 20.dp), fontWeight = FontWeight.SemiBold)
            Spacer(modifier= Modifier.heightIn(10.dp))
            var firstName by remember{mutableStateOf("")}
            var lastName by remember{ mutableStateOf("") }
            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            var confirmPassword by remember{mutableStateOf("")}
            MyTextField(labelValue = "First Name", painterResource(R.drawable.user) , value =firstName , onValueChange ={firstName=it} )
            MyTextField(labelValue = "Last Name", painterResource (R.drawable.user) , value =lastName , onValueChange ={lastName=it} )
            MyTextField(labelValue = "Email",
                painterResource(R.drawable.mail),
                value = email,
                onValueChange = { email = it })
            MyTextField(labelValue = "Password",
                painterResource(R.drawable.padlock),
                value = password,
                onValueChange = { password = it })
            MyTextField(labelValue = "Confirm Password",
                painterResource(R.drawable.padlock),
                value = confirmPassword,
                onValueChange = { confirmPassword = it })
            Spacer(modifier = Modifier.heightIn(20.dp))
            Button(onClick = {  navController.navigate("mainPage1")  }, modifier= Modifier
                .fillMaxWidth()
                .heightIn(48.dp),
                contentPadding= PaddingValues(),
                colors= ButtonDefaults.buttonColors(Color.Transparent)) {
                Box(modifier= Modifier
                    .fillMaxWidth(0.5f)
                    .heightIn(48.dp)
                    .background(
                        color=Color(0xFF1D5B23),
                        shape = RoundedCornerShape(10.dp)
                    ), contentAlignment = Alignment.Center

                ) {
                    Text(
                        text = "Sign Up",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                        color=Color.Black
                    )
                }
            }
            Spacer(modifier=Modifier.heightIn(10.dp))
            ClickableLoginTextComponent(tryingToLogin = true, onTextSelected = {
                navController.navigate("homePage") {

                }

            })

        }
    }
}

@Preview
@Composable
fun signUpPreview(){
    //signUpPage()
}