package com.example.perqaragames.presentation.game_details

import com.example.perqaragames.domain.model.GameDetails


data class GameDetailsState(
    val isLoading: Boolean = false,
    val gameDetails: GameDetails? = null,
    val error: String? = null,
    val isFavorite: Boolean = false
)
