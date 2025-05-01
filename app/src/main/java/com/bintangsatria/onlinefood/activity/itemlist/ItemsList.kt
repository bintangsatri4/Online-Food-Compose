package com.bintangsatria.onlinefood.activity.itemlist

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.bintangsatria.onlinefood.R
import com.bintangsatria.onlinefood.domain.FoodModel

@Composable
fun ItemsList(items: List<FoodModel>) {
    LazyColumn(modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)) {
        itemsIndexed(items) { index, item ->
            Items(item = item, index = index)
        }
    }
}

@Composable
fun Items(item: FoodModel, index: Int) {
    val context = LocalContext.current
    val isEvenRow = index % 2 == 0

    Row (modifier = Modifier
        .padding(vertical = 8.dp)
        .fillMaxWidth()
        .background(color = colorResource(R.color.grey),
            shape = RoundedCornerShape(10.dp))
        .wrapContentHeight()
        .clickable{

        }){

        if (isEvenRow) {
            FoodImage(item = item)
            FoodDetails(item = item)
        } else {

        }
    }

}

@Composable
fun FoodImage(item: FoodModel) {
    AsyncImage(
        model = item.ImagePath,
        contentDescription = null,
        modifier = Modifier
            .size(120.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color = colorResource(R.color.grey), shape = RoundedCornerShape(10.dp)),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun RowScope.FoodDetails(item: FoodModel) {

    Column (modifier = Modifier
        .padding(start = 10.dp)
        .fillMaxHeight()
        .weight(1f)
    ){
        Text(
            text = item.Title,
            color = colorResource(R.color.darkPurple),
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(top = 12.dp)
        )
    }
}
