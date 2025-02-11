package com.bintangsatria.onlinefood

import android.os.Bundle
import android.window.SplashScreen

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }
}
@Composable
@Preview
fun SplashScreen(){
    Column( modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(id = R.color.darkBrown))
    ) {
        ConstraintLayout(modifier = Modifier.padding(top = 48.dp)) {
            val(backgroundImg,logiImg) = createRefs()
            Image(
                painter = painterResource(id = R.drawable.intro_pic),
                contentDescription = null,
                modifier = Modifier
                    .constrainAs (backgroundImg){
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
//                        end.linkTo(parent.end)
//                        bottom.linkTo(parent.bottom)
                    }
                    .fillMaxWidth()
            )
            Image(
                painter = painterResource(id = R.drawable.pizza),
                contentDescription = null,

            )


        }

    }
}