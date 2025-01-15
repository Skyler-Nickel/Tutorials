package com.example.businesscard

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(modifier = Modifier.fillMaxSize()) {
        BusinessCardHelper(
            name = stringResource(R.string.name),
            description = stringResource(R.string.description),
            imagePainter = painterResource(R.drawable.android_logo),
            backgroundColor = Color(0xFFffcc00),
            modifier = Modifier,
        )
        ContactInformation(
            phoneNumber = stringResource(R.string.phoneNumber),
            social = stringResource(R.string.social),
            email = stringResource(R.string.email),
            backgroundColor = Color(0xFFffcc00),
            modifier = Modifier,
        )
    }
}

@Composable
private fun BusinessCardHelper(
    name: String,
    description: String,
    imagePainter: Painter,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(700.dp)
            .background(backgroundColor),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = imagePainter,
            contentDescription = null,
            modifier = Modifier
                .height(120.dp)
                .width(120.dp),
        )
        Text(
            text = name,
            fontWeight = FontWeight.SemiBold,
            fontSize = 40.sp,
            modifier = Modifier.padding(12.dp),
            color = Color(0xFF6200EE)
        )
        Text(
            text = description,
            fontSize = 20.sp,
            color = Color(0xFF6200EE)
        )

    }
}

@Composable
private fun ContactInformation(
    phoneNumber: String,
    social: String,
    email: String,
    backgroundColor: Color,
    modifier: Modifier
) {
    Column(
        modifier = Modifier
            .background(backgroundColor)
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column {
            Text(
                text = phoneNumber,
                fontSize = 25.sp,
                fontWeight = FontWeight.W400
            )
            Text(
                text = social,
                fontSize = 25.sp,
                fontWeight = FontWeight.W400,
            )
            Text(
                text = email,
                fontSize = 25.sp,
                fontWeight = FontWeight.W400
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}