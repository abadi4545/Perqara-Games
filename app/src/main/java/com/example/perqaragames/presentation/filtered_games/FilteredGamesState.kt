package com.example.perqaragames.presentation.filtered_games

import com.example.perqaragames.domain.model.Game


data class FilteredGamesState(
    val isLoading: Boolean = false,
    val games: List<Game>? = emptyList(),
    val error: String? = null,
)
