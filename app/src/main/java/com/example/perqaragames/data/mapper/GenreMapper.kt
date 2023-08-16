package com.example.perqaragames.data.mapper

import com.example.perqaragames.data.remote.dto.game_details.GameDetailGenre
import com.example.perqaragames.data.remote.dto.genre.GenreResult
import com.example.perqaragames.data.remote.dto.genre.GenresResponse
import com.example.perqaragames.domain.model.Genre


fun GenreResult.toGenre(): Genre = Genre(
    gamesCount = gamesCount,
    id = id,
    imageBackground = imageBackground,
    name = name,
    slug = slug
)

fun GameDetailGenre.toGenre(): Genre = Genre(
    gamesCount = gamesCount,
    id = id,
    imageBackground = imageBackground,
    name = name?:"",
    slug = slug
)


fun GenresResponse.toGenreList(): List<Genre> {
    return genreResults.map {
        it.toGenre()
    }
}