package com.kirson.iwu.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.compose.IWUTheme
import com.kirson.iwu.MainModel
import com.kirson.iwu.entities.NewsItem
import com.kirson.iwu.entities.news
import com.kirson.iwu.ui.theme.md_theme_light_onPrimary

@Composable
fun NewsScreen(viewModel: MainModel, topPadding: Dp) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
    ) {
        val news = viewModel.selectedNews.value

        news?.let {
            NewsBody(it)

        }


    }

}

@Composable
fun NewsBody(newsItem: NewsItem) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(MaterialTheme.shapes.small)
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = newsItem.drawableResId),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Text(
            modifier = Modifier.align(Alignment.BottomStart).padding(6.dp),
            style = MaterialTheme.typography.headlineMedium,
            text = newsItem.title,
            color = md_theme_light_onPrimary
        )
    }
    Text(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 5.dp),
        style = MaterialTheme.typography.bodyLarge,
        text = newsItem.description,
        fontFamily = FontFamily.SansSerif
    )
}

@Preview(showBackground = true)
@Composable
fun NewsScreenPreview() {
    IWUTheme {
        NewsScreen(viewModel = MainModel(), topPadding = 40.dp)
    }
}

@Preview(showBackground = true)
@Composable
fun NewsBodyPreview() {
    IWUTheme {
        Column {
            NewsBody(newsItem = news[0])
        }

    }

}