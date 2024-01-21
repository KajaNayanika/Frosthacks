package com.example.vydya_app

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.w3c.dom.Text

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(labelValue:String, painterResource: Painter, value:String, onValueChange: (String) -> Unit){


    OutlinedTextField(
        modifier= Modifier.fillMaxWidth(0.9f)
        ,shape= RoundedCornerShape(5.dp),
        value =value,
        label={ Text(text=labelValue) },
        colors= TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(id = R.color.white),
            focusedLabelColor = colorResource(id = R.color.black),
            cursorColor = colorResource(id = R.color.black),
            containerColor = Color(0xFFF7F8F8)

        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        onValueChange =onValueChange,
        leadingIcon = {
            Icon(painter= painterResource,contentDescription="")
        }
    )

}

@Composable
fun homeButton(text1:String){
    Button(onClick = { /*TODO*/ }, modifier= Modifier
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
                text = text1,
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                color=Color.Black
            )
        }
    }
}

@Composable
fun button(text: String){
    Button(onClick = { /*TODO*/ }, modifier= Modifier
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
                text = text,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color=Color.Black
            )
        }
    }
}

@Composable
fun ClickableLoginTextComponent(tryingToLogin: Boolean = true, onTextSelected: (String) -> Unit) {
    val initialText =
        if (tryingToLogin) "Already have an account? " else "Don’t have an account yet? "
    val loginText = if (tryingToLogin) "Login" else "Register"

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color =Color.Blue)) {
            pushStringAnnotation(tag = loginText, annotation = loginText)
            append(loginText)
        }
    }

    ClickableText(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 21.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center
        ),
        text = annotatedString,
        onClick = { offset ->

            annotatedString.getStringAnnotations(offset, offset)
                .firstOrNull()?.also { span ->
                    Log.d("ClickableTextComponent", "{${span.item}}")

                    if (span.item == loginText) {
                        onTextSelected(span.item)
                    }
                }

        },
    )
}
