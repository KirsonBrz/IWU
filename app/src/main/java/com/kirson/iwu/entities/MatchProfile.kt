package com.kirson.iwu.entities

import androidx.annotation.DrawableRes
import com.kirson.iwu.R

data class MatchProfile(
    val name: String,
    @DrawableRes val drawableResId: Int,
    val pro: Boolean,
)

val profiles = listOf(
    MatchProfile("Erlich Bachman", R.drawable.cats, true),
    MatchProfile("Richard Hendricks", R.drawable.jacket, false),
    MatchProfile("Laurie Bream", R.drawable.vet, true),
    MatchProfile("Russ Hanneman", R.drawable.walks, false),
    MatchProfile("Dinesh Chugtai", R.drawable.hub, false),
    MatchProfile("Monica Hall", R.drawable.match, false),
    MatchProfile("Bertram Gilfoyle", R.drawable.meet, false),

    MatchProfile("Peter Gregory", R.drawable.paw, false),
    MatchProfile("Jared Dunn", R.drawable.hub, false),
    MatchProfile("Nelson Bighetti", R.drawable.match, false),
    MatchProfile("Gavin Belson", R.drawable.meet, false),
    MatchProfile("Jian Yang", R.drawable.paw, false),
    MatchProfile("Jack Barker", R.drawable.hub, false),
)