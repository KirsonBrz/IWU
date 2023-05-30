package com.kirson.iwu.entities

import androidx.annotation.DrawableRes
import com.kirson.iwu.R

data class MatchProfile(
    val name: String,
    @DrawableRes val drawableResId: Int,
)

val profiles = listOf(
    MatchProfile("Erlich Bachman", R.drawable.cats),
    MatchProfile("Richard Hendricks", R.drawable.jacket),
    MatchProfile("Laurie Bream", R.drawable.vet),
    MatchProfile("Russ Hanneman", R.drawable.walks),
    MatchProfile("Dinesh Chugtai", R.drawable.hub),
    MatchProfile("Monica Hall", R.drawable.match),
    MatchProfile("Bertram Gilfoyle", R.drawable.meet),

    MatchProfile("Peter Gregory", R.drawable.paw),
    MatchProfile("Jared Dunn", R.drawable.hub),
    MatchProfile("Nelson Bighetti", R.drawable.match),
    MatchProfile("Gavin Belson", R.drawable.meet),
    MatchProfile("Jian Yang", R.drawable.paw),
    MatchProfile("Jack Barker", R.drawable.hub),
)