package com.example.vydya_app

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vydya_app.ui.theme.Vydya_appTheme
import kotlinx.coroutines.delay

@Composable
fun logoPage(onNavigate:()->Unit) {
    val scale= remember {
        androidx.compose.animation.core.Animatable(0f)
    }
    LaunchedEffect(key1=true){
scale.animateTo(
    targetValue=0.2f,
    animationSpec=tween(
        durationMillis=500,
        easing={
            OvershootInterpolator(2f).getInterpolation(it)
        }
    )
)
        delay(3000L)
        onNavigate()
    }
    Box(modifier= Modifier
        .fillMaxSize()
        .background(color = Color(0xFFE1E587)),contentAlignment = Alignment.Center) {
        Box(modifier=Modifier.fillMaxWidth()
            .clip(CircleShape), contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = R.drawable.vydya_high_resolution_logo),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(400.dp)
                    .clip(CircleShape)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Vydya_appTheme {
        //logoPage()
    }
}