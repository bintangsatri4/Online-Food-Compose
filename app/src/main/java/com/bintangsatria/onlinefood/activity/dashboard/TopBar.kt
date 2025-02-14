package com.bintangsatria.onlinefood.activity.dashboard


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import com.bintangsatria.onlinefood.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
@Preview
fun TopBar(){
    ConstraintLayout (modifier = Modifier
        .padding(top = 48.dp)
        .padding(horizontal = 16.dp)
        .fillMaxWidth()
    ){
        val (name,settings,notification) = createRefs()
        Image(painter = painterResource(R.drawable.settings_icon),
            contentDescription = null,
            modifier = Modifier
                .constrainAs(settings) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                }.clickable{}
        )
        Column(modifier = Modifier
            .constrainAs(name){
                top.linkTo(parent.top)
                start.linkTo(settings.end)
                end.linkTo(notification.start)
            },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

        }
    }
}