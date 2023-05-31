package com.kirson.iwu.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.IWUTheme
import com.kirson.iwu.R

@OptIn(ExperimentalTextApi::class)
@Composable
fun IWULogo(){
    Row(modifier = Modifier.padding(start = 20.dp)) {
        Icon(
            painterResource(id = R.drawable.paw),
            contentDescription = null,
            Modifier.size(36.dp),
            tint = MaterialTheme.colorScheme.primary
        )
        Text(
            modifier = Modifier
                .padding(horizontal = 5.dp)
                .height(36.dp),
            text = "IWU",
            style = TextStyle(
                brush = Brush.linearGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primary,
                        MaterialTheme.colorScheme.secondary
                    )
                ),
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                fontSize = 28.sp
            ),
        )
    }
    Text(
        modifier = Modifier.padding(start = 100.dp),
        text = "beta",
        style = TextStyle(
            brush = Brush.linearGradient(
                colors = listOf(
                    MaterialTheme.colorScheme.primary,
                    MaterialTheme.colorScheme.secondary
                )
            ),
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            fontSize = 8.sp
        ),
    )
}

@Preview(showBackground = true)
@Composable
fun IWULogoPreview() {
    IWUTheme {
        IWULogo()
    }
}