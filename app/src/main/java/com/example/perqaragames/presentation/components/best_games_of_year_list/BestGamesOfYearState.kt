package com.example.perqaragames.presentation.components.best_games_of_year_list

import com.example.perqaragames.domain.model.Game


data class BestGamesOfYearState(
    val isLoading: Boolean = false,
    val error: String = "",
    val games: List<Game> = emptyList()
)