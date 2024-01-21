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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HospitalInner(){
    var snackbarHostState = remember { SnackbarHostState() }
    var scope = rememberCoroutineScope()
    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)

    ){it->
    Box(modifier= Modifier
        .fillMaxSize()
        .background(color = Color.White)) {
        Column(
            modifier = Modifier.fillMaxSize().padding(it),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.heightIn(20.dp))
            Image(
                painter = painterResource(id = R.drawable.hosp),
                contentDescription = "Hospital image", modifier = Modifier.size(300.dp)
            )
            Text(text = "Hospitals")
            Spacer(modifier = Modifier.heightIn(20.dp))
            Text(text = "About")
            Text(
                text = "After clicking on the button below,it directly sends an alert notification to a hospital located nearby to the person, " +
                        "following this an ambulance will be sent to your mentioned address." +
                        "If sure click 'Confirm the hospital' "
            )
            Spacer(modifier = Modifier.heightIn(35.dp))
            Button(
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar("Alert has been sent")
                    }
                }, modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(48.dp),
                contentPadding = PaddingValues(),
                colors = ButtonDefaults.buttonColors(Color.Transparent)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .heightIn(48.dp)
                        .background(
                            color = Color(0xFFE1E587),
                            shape = RoundedCornerShape(10.dp)
                        ), contentAlignment = Alignment.Center

                ) {
                    Text(
                        text = "Confirm the hospital",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                }
            }
        }
    }
}
}

@Preview
@Composable
fun HIPreview(){
    HospitalInner()
}
