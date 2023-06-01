package com.kirson.iwu.entities

import androidx.annotation.DrawableRes
import com.kirson.iwu.R

data class VetProfile(
    val name: String,
    @DrawableRes val drawableResId: Int,
    val description: String,
    val adress: String,
)

val veterinars = listOf(
    VetProfile(
        "Володин Евгений",
        R.drawable.vet1,
        "Главный врач, Терапевт",
        "Санкт-Петербург, проспект Просвещения, д.74 к2"
    ),
    VetProfile(
        "Михайлов Илья",
        R.drawable.vet2,
        "Главный врач, онколог, хирург, пластический хирург",
        "Санкт-Петербург, проспект Просвещения, д.74 к2"
    ),
    VetProfile(
        "Кудряшев Иван",
        R.drawable.vet3,
        "Главный врач, хирург, анестезиолог",
        "Санкт-Петербург, проспект Просвещения, д.74 к2"
    ),
    VetProfile(
        "Гайгальник Евгений",
        R.drawable.vet4,
        "Главный врач, терапевт, хирург",
        "Санкт-Петербург, проспект Просвещения, д.74 к2"
    ),
    VetProfile(
        "Черников Анатолий",
        R.drawable.vet5,
        "Главный врач, хирург, стоматолог, гастроэнтеролог",
        "Санкт-Петербург, проспект Просвещения, д.74 к2"
    ),
    VetProfile(
        "Фридман Михаил",
        R.drawable.vet6,
        "Главный врач, хирург, травматолог",
        "Санкт-Петербург, проспект Просвещения, д.74 к2"
    ),
)