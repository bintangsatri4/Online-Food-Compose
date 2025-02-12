package com.bintangsatria.onlinefood.activity.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.bintangsatria.onlinefood.R

@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen(onGetStartClick = { })
}

@Composable
fun SplashScreen(onGetStartClick: () -> Unit) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(id = R.color.darkBrown))
    ) {
        ConstraintLayout(modifier = Modifier.padding(top = 48.dp)) {
            val (backgroundImg, logiImg) = createRefs()
            Image(
                painter = painterResource(id = R.drawable.intro_pic),
                contentDescription = null,
                modifier = Modifier
                    .constrainAs(backgroundImg) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
                    .fillMaxWidth()
            )
            Image(
                painter = painterResource(id = R.drawable.pizza),
                contentDescription = null,
                modifier = Modifier.constrainAs(logiImg) {
                    top.linkTo(backgroundImg.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(backgroundImg.bottom)
                },
                contentScale = ContentScale.Fit
            )
        }
        val styledText = buildAnnotatedString {
            append("Welcome to your")
            withStyle(style = SpanStyle(color = colorResource(id = R.color.orange))) {
                append(" food\nparadis ")
            }
            append("experience food perfection delivered")
        }
        Text(
            text = styledText,
            fontSize = 27.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .padding(top = 32.dp)
                .padding(horizontal = 16.dp)
        )

        Text(
            text = stringResource(R.string.splashSubtitle),
            fontSize = 16.sp,
            color = Color.White,
            modifier = Modifier.padding(20.dp)
        )

        GetStartedButton(
            onClick = onGetStartClick,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}