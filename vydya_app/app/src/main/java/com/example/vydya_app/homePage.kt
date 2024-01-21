package com.example.vydya_app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun homePage(navController: NavController) {
    Box(modifier= Modifier
        .fillMaxSize()
        .background(color = Color(0xFFB6B971))
        , contentAlignment = Alignment.Center) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement=Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text="Hey there,Welcome back!",color=Color(0xFF1D5B23),fontSize=30.sp,
                modifier=Modifier.padding(top = 20.dp), fontWeight = FontWeight.SemiBold)
            Spacer(modifier=Modifier.heightIn(25.dp))

            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            MyTextField(labelValue = "Email",
                painterResource(R.drawable.mail),
                value = email,
                onValueChange = { email = it })
            MyTextField(labelValue = "Password",
                painterResource(R.drawable.padlock),
                value = password,
                onValueChange = { password = it })
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
                        text = "Login",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Normal,
                        color=Color.Black
                    )
                }
            }
            Spacer(modifier=Modifier.heightIn(15.dp))
            Text(text="Forgot password?", textDecoration = TextDecoration.Underline)
            Spacer(modifier=Modifier.heightIn(10.dp))
            ClickableLoginTextComponent(tryingToLogin = false, onTextSelected = {
                navController.navigate("SignUp") {
                    popUpTo("Login") {
                        inclusive = true
                    }
                }
            })

        }
    }
}

@Preview
@Composable
fun pagePreview(){
    //homePage()
}

    

