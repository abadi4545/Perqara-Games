package com.example.perqaragames.core.utils

import com.example.perqaragames.domain.model.Game


fun yearStringToDateRangeString(year: String): String {
    return "$year-01-01,$year-12-31"
}

fun getRatingWithRatingCount(game: Game): String {
    return "${game.rating?:"-"} / ${game.ratingTop?:"-"}"
}