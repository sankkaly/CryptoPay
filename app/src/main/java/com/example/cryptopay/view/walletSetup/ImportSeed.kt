package com.example.cryptopay.view.walletSetup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cryptopay.R

@Composable
@Preview
fun ImportSeed(){
    var text by remember { mutableStateOf("") }
    var isToggled by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxWidth()
        .fillMaxHeight()
        .background(Color.Black),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.background(Color.Black)
                .padding(16.dp, 0.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.size(20.dp))
            Box(
                Modifier.fillMaxWidth()
                    .padding(0.dp, 16.dp)

            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "Arrow left",
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)
                        .align(Alignment.CenterStart)// Adjust the size of the icon
                )
                Text(
                    "Import From Seed",
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            Spacer(Modifier.size(20.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                    label = { Text("Seed Phrase") },
                    trailingIcon = { Image(
                        painter = painterResource(R.drawable.eyevisble),
                        contentDescription = "visiblity icon",
                        Modifier.size(25.dp)
                    ) },
                    shape = RoundedCornerShape(12.dp)
                )

                Image(
                    painter = painterResource(R.drawable.qrscanner),
                    contentDescription = "visiblity icon",
                    Modifier.size(35.dp)
                )
                Spacer(Modifier.size(2.dp))
            }
            Spacer(Modifier.size(25.dp))
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("New Password") },
                trailingIcon = { Image(
                    painter = painterResource(R.drawable.eyevisble),
                    contentDescription = "visiblity icon",
                    Modifier.size(25.dp)
                ) },
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.size(25.dp))
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Confirm Password") },
                trailingIcon = { Image(
                    painter = painterResource(R.drawable.eyevisble),
                    contentDescription = "visiblity icon",
                    Modifier.size(25.dp)
                ) },
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(Modifier.size(25.dp))
            Row(verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Sign in with Face ID?",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                )
                Switch(
                    checked = isToggled,
                    onCheckedChange = { isToggled = it },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.White,         // Thumb color when ON
                        uncheckedThumbColor = Color.White,         // Thumb color when OFF
                        checkedTrackColor =  Color(0xff3D8DFF),     // Track color when ON
                        uncheckedTrackColor = Color.LightGray     // Track color when OFF
                    )
                )
            }
            Spacer(Modifier.size(25.dp))
            TermsAndConditionsText { }
        }
        Row (modifier = Modifier.fillMaxWidth().padding(16.dp,16.dp)){
            Button(
                modifier = Modifier.fillMaxWidth()
                    .height(50.dp)
                    .padding(16.dp, 0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff202832)
                ),
                onClick = {}
            ) { Text(text = "Import using Seed Phrases")}
        }
    }

}

@Composable
fun TermsAndConditionsText(
    onTermsClick: () -> Unit,
) {
    // Building the annotated string
    val annotatedString = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.Gray)) {
            append("By proceeding, you agree to these ")
        }

        // Adding the clickable part
        pushStringAnnotation(
            tag = "Terms", // Identifier for the annotation
            annotation = "terms" // You can use this for navigation or further logic
        )
        withStyle(style = SpanStyle(color = Color(0xff3D8DFF), textDecoration = TextDecoration.Underline)) {
            append("Terms and Conditions")
        }
        pop()
    }

    // Clickable text composable
    ClickableText(
        text = annotatedString,
        onClick = { offset ->
            // Handle click by checking the tag
            annotatedString.getStringAnnotations(tag = "Terms", start = offset, end = offset)
                .firstOrNull()?.let {
                    // If clicked, trigger the action
                    onTermsClick()
                }

        },
        modifier = Modifier.fillMaxWidth()
    )
}
