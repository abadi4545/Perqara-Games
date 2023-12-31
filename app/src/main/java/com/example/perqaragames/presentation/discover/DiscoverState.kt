package com.example.perqaragames.presentation.discover

import androidx.paging.PagingData
import com.example.perqaragames.domain.model.Game
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

data class DiscoverState(
    val isLoading: Boolean = false,
    val error: String = "",
    val bestOfAllTimeGames: Flow<PagingData<Game>> = flow { },
)
