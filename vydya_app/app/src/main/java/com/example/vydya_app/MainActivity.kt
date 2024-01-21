package com.example.vydya_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.vydya_app.ui.theme.Vydya_appTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Vydya_appTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }

            var navController: NavHostController = rememberNavController()
            NavHost(navController = navController, startDestination = "logoPage"){
                composable("logoPage"){
                    logoPage(onNavigate = {
                        navController.navigate("signInUp") {

                        }
                    })
                }

                composable("signInUp"){
                    signInUp(navController =navController)
                }
                composable("signUp"){
                    signUpPage(onNavigate={
                        navController.navigate("mainPage1")
                    },navController=navController)
                }
                composable("homePage"){
                    homePage(navController=navController)
                }
                composable("mainPage1"){
                    Hospital(navController=navController)


                }
                composable("hospInnerPage"){
                    HospitalInner()
                }
                composable("AboutMe"){
                    AboutMeInner()
                }
            }
        }

    }

}

