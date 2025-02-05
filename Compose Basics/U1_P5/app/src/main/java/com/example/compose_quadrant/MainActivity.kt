package com.example.compose_quadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_quadrant.ui.theme.Compose_QuadrantTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_QuadrantTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Quadrant()
                }
            }
        }
    }
}

@Composable
fun Quadrant() {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(0.5f)) {
            QuadrantHelper(
                firstText = stringResource(R.string.text_compose),
                secondText = stringResource(R.string.text_description),
                backgroundColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(0.5f)
            )
            QuadrantHelper(
                firstText = stringResource(R.string.image_compose),
                secondText = stringResource(R.string.image_description),
                backgroundColor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(0.5f)
            )
        }
        Row(Modifier.weight(0.5f)) {
            QuadrantHelper(
                firstText = stringResource(R.string.row_compose),
                secondText = stringResource(R.string.row_description),
                backgroundColor = Color(0xFFB69DF8),
                modifier = Modifier.weight(0.5f)
            )
            QuadrantHelper(
                firstText = stringResource(R.string.column_compose),
                secondText = stringResource(R.string.column_description),
                backgroundColor = Color(0xFFF6EDFF),
                modifier = Modifier.weight(0.5f)
            )
        }
    }
}

@Composable
private fun QuadrantHelper(
    firstText: String,
    secondText: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = firstText,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = secondText,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeQuadrantPreview() {
    Compose_QuadrantTheme {
        Quadrant()
    }
}