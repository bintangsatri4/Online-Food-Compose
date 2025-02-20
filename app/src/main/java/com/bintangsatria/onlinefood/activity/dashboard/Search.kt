package com.bintangsatria.onlinefood.activity.dashboard

import android.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.nio.file.WatchEvent

@Composable
@Preview
fun Search(){
    var text by rememberSaveable { mutableStateOf("") }
    TextField(value = text, onValueChange = { text = it },
        label = {
            Text(text = "What do you want to eat?",
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Medium,
                color = Color.DarkGray,
                fontSize = 14.sp)
        },
        trailingIcon = {
            Image(painter = painterResource(id = R.drawable.ic_menu_search),
                contentDescription = null,
                modifier = Modifier.size(22.dp))
        },
        shape = RoundedCornerShape(15.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = colorResource(id = com.bintangsatria.onlinefood.R.color.grey),
            focusedBorderColor = Color.Transparent,
            unfocusedLabelColor = Color.Transparent,
            textColor = Color.DarkGray,
            unfocusedBorderColor = Color.Transparent

        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(50.dp)
            .background(colorResource(id = com.bintangsatria.onlinefood.R.color.grey), CircleShape)

        )
}