package com.example.perqaragames.core.enums

enum class GamesOrderType(val value: String) {

    NAME("name"),
    RELEASE_DATE("released"),
    RATING("rating"),
    ADDED("added"),
    UPDATED("updated"),
    CREATED("created"),
    METACRITIC("metacritic");

    fun reverse(): String{
        return "-${value}"
    }
}

