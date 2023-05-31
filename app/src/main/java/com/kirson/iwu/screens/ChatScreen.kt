package com.kirson.iwu.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compose.IWUTheme
import com.kirson.iwu.MainModel

@Composable
fun ChatScreen(
    viewModel: MainModel = viewModel(),
    topPadding: Dp
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = topPadding)
            .verticalScroll(rememberScrollState())
    ) {

    }
}

@Preview(showBackground = true)
@Composable
fun ChatScreenPreview() {
    IWUTheme {
        ChatScreen(viewModel = MainModel(), 40.dp)
    }

}