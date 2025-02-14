package com.bintangsatria.onlinefood.activity.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bintangsatria.onlinefood.MainActivity
import com.bintangsatria.onlinefood.R

@Composable
@Preview
fun GetStartedButton(onClick: () ->Unit={},modifier: Modifier = Modifier){
    Row (modifier = modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp)
    ){
        Button(onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            ),
            shape = RoundedCornerShape(50.dp)
            , modifier =  modifier
                .padding(end = 16.dp)
                .fillMaxWidth(0.35f)
                .border(1.dp,Color.White, shape = RoundedCornerShape(50.dp))
                .height(50.dp)
        ) {
            Text(
                text = "Sign Up",
                fontSize = 16.sp,
                color = Color.White

            )
        }

        //Sign In Button

        Button(onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.orange)
            ),
            shape = RoundedCornerShape(50.dp)
            , modifier =  modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(
                text = "Get Started",
                fontSize = 16.sp,
                color = Color.White

            )
        }

    }

}