package com.kirson.iwu.entities

import androidx.annotation.DrawableRes
import com.kirson.iwu.R

data class NewsItem(
    val title: String,
    @DrawableRes val drawableResId: Int,
    val subtitle: String,
    val description: String,
)

val news = listOf(
    NewsItem(
        title = "Помогите найти дом!",
        subtitle = "Эти милые котята нуждаются в любящих хозяевах....",
        drawableResId = R.drawable.cats,
        description = "Эти милые котята нуждаются в любящих хозяевахЭти милые котята нуждаются в любящих хозяевахЭти милые котята нуждаются в любящих хозяевах"
    ),
    NewsItem(
        title = "Гуляйте вместе!",
        subtitle = "Совместные прогулки повышают уровень счастья...",
        drawableResId = R.drawable.walks,
        description = "Совместные прогулки повышают уровень счастьяСовместные прогулки повышают уровень счастьяСовместные прогулки повышают уровень счастьяСовместные прогулки повышают уровень счастьяСовместные прогулки повышают уровень счастьяСовместные прогулки повышают уровень счастьяСовместные прогулки повышают уровень счастьяСовместные прогулки повышают уровень счастья"
    ),
    NewsItem(
        title = "Одежда для собак: правда и вымысел",
        subtitle = "Самые популярные мифы и заблуждения...",
        drawableResId = R.drawable.jacket,
        description = ""
    ),
    NewsItem(
        title = "Есть, где погулять!",
        subtitle = "Зоны для выгула питомцев на карте...",
        drawableResId = R.drawable.map,
        description = ""
    )
)
