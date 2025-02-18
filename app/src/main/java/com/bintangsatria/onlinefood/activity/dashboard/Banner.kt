package com.bintangsatria.onlinefood.activity.dashboard

import android.media.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.request.ImageResult
import coil.size.Size
import com.bintangsatria.onlinefood.domain.BannerModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

@Composable

fun  Banner(banners: SnapshotStateList<BannerModel>,showBannerLoading: Boolean){
    if (showBannerLoading){
        Box(modifier = Modifier
            .fillMaxSize()
            .height(200.dp),
            contentAlignment = Alignment.Center

        ){
            CircularProgressIndicator()
        }

    }else{
Banners(banners)
    }

}

@Composable
fun CircularProgressIndicator() {
    TODO("Not yet implemented")
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Banners(banners: List<BannerModel>){
  AutoSlidingCarousel(banners=banners)

}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun AutoSlidingCarousel(modifier: Modifier= Modifier,
                       pagerState: PagerState = remember { PagerState() },
                       banners: List<BannerModel>) {

    val isDragged = pagerState.interactionSource.collectIsDraggedAsState()

    Column(modifier= Modifier .fillMaxSize()){
        HorizontalPager(count = banners.size, state = pagerState) { page ->
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(banners[page].image)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .padding(16.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .height(150.dp)


            )
        }

    }

}

@Composable
fun DotIndicator(){

}

@Composable
fun IndicatorDot(
    modifier: Modifier= Modifier,
    size: Dp,
    color: Color


){
    Box(modifier = modifier
        .size(size)
        .clip(CircleShape)
        .background(color)
    )

}

