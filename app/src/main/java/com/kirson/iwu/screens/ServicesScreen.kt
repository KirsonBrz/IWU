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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.IWUTheme
import com.kirson.iwu.R

@OptIn(ExperimentalTextApi::class)
@Composable
fun ServicesScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 56.dp, start = 16.dp, end = 16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Row {
            Icon(
                painterResource(id = R.drawable.paw),
                contentDescription = null,
                Modifier.size(50.dp),
                tint = MaterialTheme.colorScheme.primary
            )
            Text(
                modifier = Modifier.padding(horizontal = 5.dp).height(50.dp),
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
                    fontSize = 40.sp
                ),
            )
        }
        Text(
            modifier = Modifier.padding(horizontal = 105.dp),
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
                fontSize = 12.sp
            ),

        )

        Spacer(modifier = Modifier.height(40.dp))
        VetCard()
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
                    title = "Помогите найти дом!",
                    subtitle = "Эти милые котята нуждаются в любящих хозяевах....",
                    imageID = R.drawable.cats
                )
                Spacer(modifier = Modifier.weight(0.05f))
                NewsCard(
                    modifier = Modifier.weight(1f),
                    title = "Гуляйте вместе!",
                    subtitle = "Совместные прогулки повышают уровень счастья...",
                    imageID = R.drawable.walks

                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier.height(240.dp)) {
                NewsCard(
                    modifier = Modifier.weight(1f),
                    title = "Одежда для собак: правда и вымысел",
                    subtitle = "Самые популярные мифы и заблуждения...",
                    imageID = R.drawable.jacket
                )
                Spacer(modifier = Modifier.weight(0.05f))
                NewsCard(
                    modifier = Modifier.weight(1f),
                    title = "Есть, где погулять!",
                    subtitle = "Зоны для выгула питомцев на карте...",
                    imageID = R.drawable.map
                )
            }
        }
    }
}

@Composable
fun NewsCard(
    modifier: Modifier,
    title: String,
    subtitle: String,
    imageID: Int,
) {
    Card(
        modifier
    ) {
        Box {
            Image(
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(imageID),
                contentDescription = null
            )
            Scrim(Modifier.align(Alignment.BottomCenter))
            Column(Modifier.align(Alignment.BottomStart)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(10.dp),
                    minLines = 2,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }
}

@Composable
fun VetCard() {
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
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.padding(horizontal = 10.dp)
                )
                Text(
                    text = "Лучшие ветеринары вашего \nгорода в один клик!",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(10.dp),
                    minLines = 2,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
            FilledTonalButton(
                onClick = {},
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(10.dp),
            ) {
                Text("Заказать")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ServicesScreenPreview() {
    IWUTheme {
        ServicesScreen()
    }
}