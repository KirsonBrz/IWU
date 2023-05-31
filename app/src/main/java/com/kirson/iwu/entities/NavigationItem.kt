package com.kirson.iwu.entities

import com.kirson.iwu.R

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Login : NavigationItem("login", R.drawable.meet, "Вход")
    object Registration : NavigationItem("registration", R.drawable.meet, "Регистрация")
    object Pets : NavigationItem("pets", R.drawable.meet, "Питомцы")
    object Services : NavigationItem("services", R.drawable.hub, "Сервисы")
    object Reactions : NavigationItem("reactions", R.drawable.match, "Реакции")
    object Chat : NavigationItem("chat", R.drawable.chat, "Чат")
    object Profile : NavigationItem("profile", R.drawable.profile, "Профиль")
}
