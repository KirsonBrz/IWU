package com.kirson.iwu.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.BuildCircle
import androidx.compose.material.icons.outlined.DryCleaning
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.IWUTheme

@Composable
fun EmptyScreen(topPadding: Dp) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.size(150.dp),
            imageVector = Icons.Outlined.Build,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurface
        )
        Text(
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(top = 300.dp),
            text = "В разработке",
            fontSize = 40.sp,
        )

    }

}

@Preview(showBackground = true)
@Composable
fun EmptyScreenPreview() {
    IWUTheme {
        EmptyScreen(topPadding = 40.dp)
    }
}