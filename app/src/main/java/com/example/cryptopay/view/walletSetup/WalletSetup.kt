package com.example.cryptopay.view.walletSetup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.cryptopay.R

@Composable
@Preview
fun WalletSetup(){
    ConstraintLayout(
        Modifier.fillMaxSize()
            .background(Color.Black)
    ) {
        val (image,text,button) = createRefs();
        val color: List<Color> = listOf(Color(0xff8AD4EC), Color(0xffEF96FF),Color(0xffFF56A9),Color(0xffFFAA6C))
        val brush = Brush.linearGradient(
            colors = color,
            start = Offset(0f, 0f),
            end = Offset(800f, 1f)
        )

        Image(painter = painterResource(R.drawable.walletsetup),
            "image",
            modifier = Modifier.size(250.dp, 250.dp)
                .constrainAs(image){
                    top.linkTo(parent.top, margin = 100.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        Text(
            text = "Wallet Setup",
            fontSize = 30.sp,
            color = Color.White,
            modifier = Modifier.constrainAs(text){
                top.linkTo(image.bottom, margin = 120.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(button.top)
            }
        )

        Column(Modifier.constrainAs(button){
            top.linkTo(text.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom, margin = 30.dp)
        }) {
            Button(
                modifier = Modifier.fillMaxWidth()
                    .height(50.dp)
                    .padding(16.dp, 0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff202832)
                ),
                onClick = {}
            ) { Text(text = "Import using Seed Phrases")}

            Spacer(Modifier.size(15.dp))

            Button(
                modifier = Modifier.fillMaxWidth()
                    .height(50.dp)
                    .padding(16.dp, 0.dp)
                    .clip(RoundedCornerShape(35.dp))
                    .background(brush = brush),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                onClick = {}
            ) { Text(text = "Create a New Wallet")}
        }


    }
}