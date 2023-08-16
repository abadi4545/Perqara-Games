package com.example.perqaragames.presentation.favorites

import com.example.perqaragames.domain.model.GameDetails

data class FavoritesState(
    val isLoading: Boolean = false,
    val favorites: List<GameDetails> = emptyList(),
    val error: String = "",
)
