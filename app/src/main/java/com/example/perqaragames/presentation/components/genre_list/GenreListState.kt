package com.example.perqaragames.presentation.components.genre_list

import com.example.perqaragames.domain.model.Genre


data class GenreListState(
    val isLoading: Boolean = false,
    val error: String = "",
    val genres: List<Genre> = emptyList()
)
