package com.example.task_manager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task_manager.ui.theme.Task_ManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Task_ManagerTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Manager()
                }
            }
        }
    }
}

@Composable
fun Manager() {
    ManagerHelper(
        firstText = stringResource(R.string.compose_first_text),
        secondText = stringResource(R.string.compose_second_text),
        imagePainter = painterResource(R.drawable.ic_task_completed)
    )
}

@Composable
private fun ManagerHelper(
    firstText: String,
    secondText: String,
    imagePainter: Painter,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = imagePainter, contentDescription = null)
        Text(
            text = firstText,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = secondText,
            fontSize = 16.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ManagerPreview() {
    Task_ManagerTheme {
        Manager()
    }
}