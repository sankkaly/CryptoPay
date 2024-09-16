package com.example.cryptopay.view.start
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.cryptopay.model.WalkthroughItem
import com.example.cryptopay.model.items
import com.google.accompanist.pager.*
import com.google.accompanist.pager.ExperimentalPagerApi


@OptIn(ExperimentalPagerApi::class)
@Composable
fun WalkthroughScreen(items: List<WalkthroughItem>) {
    val pagerState = rememberPagerState()
    val color: List<Color> = listOf(Color(0xff8AD4EC), Color(0xffEF96FF),Color(0xffFF56A9),Color(0xffFFAA6C))
    val brush = Brush.linearGradient(
        colors = color,
        start = Offset(0f, 0f),
        end = Offset(350f, 1f)
    )

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
//        verticalArrangement = Arrangement.Top,
//        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val (pager, dots, button) = createRefs();

        // Horizontal Pager for sliding images
        HorizontalPager(
            count = items.size,
            state = pagerState,
            modifier = Modifier
                .fillMaxSize(.6f)
                .background(Color.Black)
                .constrainAs(pager){
                    top.linkTo(parent.top, margin = 50.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(dots.top)
                }
                 // Make it take most of the screen height
        ) { page ->
            Column(
                modifier = Modifier.wrapContentSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                ImageSlide(imageResId = items[page].imageResId)
                Spacer(modifier = Modifier.height(16.dp))

                //Text
                Text(
                    text = items[page].nameA,
                    modifier = Modifier,
                    fontSize = 25.sp,
                    color = Color.White,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = items[page].nameB,
                    modifier = Modifier,
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(
                        brush = brush,
                        letterSpacing = 2.sp
                    )
                )
            }
        }

        // Dots indicator
        DotsIndicator(
            totalDots = items.size,
            selectedIndex = pagerState.currentPage,
            Modifier.constrainAs(dots){
                top.linkTo(pager.bottom, margin = 90.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(button.top)

            }
        )

        Button(
            modifier = Modifier.fillMaxWidth()
                .height(50.dp)
                .padding(16.dp, 0.dp)
                .constrainAs(button){
                    top.linkTo(dots.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom, margin = 50.dp)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff202832)
                ),
            onClick = {}
        ) { Text(text = "Get Start")}
    }
}

@Composable
fun ImageSlide(imageResId: Int) {
    Image(
        painter = painterResource(id = imageResId),
        contentDescription = "Walkthrough image",
        contentScale = ContentScale.Crop,
        modifier = Modifier.size(250.dp, 250.dp)
    )
}

@Composable
fun DotsIndicator(totalDots: Int, selectedIndex: Int, modifier: Modifier) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        for (i in 0 until totalDots) {
            val color = if (i == selectedIndex) Color.Blue else Color.Gray
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(color)
                    .padding(4.dp)
            )
            Spacer(Modifier.size(10.dp))
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Preview(showBackground = true)
@Composable
fun PreviewWalkthroughScreen() {
    WalkthroughScreen(items)
}


