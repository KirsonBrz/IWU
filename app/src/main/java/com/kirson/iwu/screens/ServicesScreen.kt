package com.kirson.iwu.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.compose.IWUTheme
import com.kirson.iwu.MainModel
import com.kirson.iwu.R
import com.kirson.iwu.entities.NavigationItem
import com.kirson.iwu.entities.NewsItem
import com.kirson.iwu.entities.news
import com.kirson.iwu.ui.theme.md_theme_light_onPrimary

@Composable
fun ServicesScreen(
    navController: NavController,
    viewModel: MainModel = viewModel(),
    topPadding: Dp
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = topPadding)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        VetCard(navController)
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Новости",
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = "Согласно вашим интересам",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Light
        )
        Column(modifier = Modifier.padding(vertical = 8.dp)) {
            Row(modifier = Modifier.height(270.dp)) {
                NewsCard(
                    modifier = Modifier.weight(1f),
                    news[0]
                ) {
                    viewModel.setNews(it)
                    navController.navigate(NavigationItem.News.route) {
                        launchSingleTop = true
                        restoreState = false
                    }
                }
                Spacer(modifier = Modifier.weight(0.05f))
                NewsCard(
                    modifier = Modifier.weight(1f),
                    news[1]
                ) {
                    viewModel.setNews(it)
                    navController.navigate(NavigationItem.News.route) {
                        launchSingleTop = true
                        restoreState = false
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier.height(240.dp)) {
                NewsCard(
                    modifier = Modifier.weight(1f),
                    news[2]
                ) {
                    viewModel.setNews(it)
                    navController.navigate(NavigationItem.News.route) {
                        launchSingleTop = true
                        restoreState = false
                    }
                }
                Spacer(modifier = Modifier.weight(0.05f))
                NewsCard(
                    modifier = Modifier.weight(1f),
                    news[3]
                ) {
                    viewModel.setNews(it)
                    navController.navigate(NavigationItem.News.route) {
                        launchSingleTop = true
                        restoreState = false
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsCard(
    modifier: Modifier,
    item: NewsItem,
    navToNews: (NewsItem) -> Unit,
) {

    Card(
        onClick = {navToNews(item)},
        modifier,

        ) {
        Box {
            Image(
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(item.drawableResId),
                contentDescription = null
            )
            Scrim(Modifier.align(Alignment.BottomCenter))
            Column(Modifier.align(Alignment.BottomStart)) {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.titleLarge,
                    color = md_theme_light_onPrimary,
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
                Text(
                    text = item.subtitle,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(10.dp),
                    minLines = 2,
                    color = md_theme_light_onPrimary
                )
            }
        }
    }
}

@Composable
fun VetCard(navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Box {
            Image(
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(R.drawable.vet),
                contentDescription = null
            )
            Scrim(Modifier.align(Alignment.BottomCenter))
            Column(Modifier.align(Alignment.BottomStart)) {
                Text(
                    text = "В поиске ветеринара?",
                    style = MaterialTheme.typography.titleLarge,
                    color = md_theme_light_onPrimary,
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
                Text(
                    text = "Лучшие ветеринары вашего \nгорода в один клик!",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(10.dp),
                    minLines = 2,
                    color = md_theme_light_onPrimary
                )
            }
            FilledTonalButton(
                onClick = {
                    navController.navigate(NavigationItem.VetList.route) {
                        launchSingleTop = true
                    }
                },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(10.dp),
            ) {
                Text("Найти")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ServicesScreenPreview() {
    IWUTheme {
        ServicesScreen(
            navController = rememberNavController(),
            viewModel = MainModel(), 40.dp
        )
    }
}