package com.kirson.iwu.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compose.IWUTheme
import com.kirson.iwu.MainActivity
import com.kirson.iwu.MainModel

@Composable
fun ReactionsScreen(
    viewModel: MainModel,
    topPadding: Dp
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = topPadding)
    ) {

        LazyColumn {
            items(viewModel.likedPets) {
                Text(modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp), text = it.name)
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun ReactionsScreenPreview() {
    IWUTheme {
        ReactionsScreen(viewModel = MainModel(), 40.dp)
    }

}