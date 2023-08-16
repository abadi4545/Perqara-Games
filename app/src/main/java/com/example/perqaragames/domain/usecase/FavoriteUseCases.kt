package com.example.perqaragames.domain.usecase

import com.example.perqaragames.data.repository.RawgRepository
import com.example.perqaragames.domain.model.GameDetails
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class FavoriteUseCases @Inject constructor(
    private val rawgRepository: RawgRepository
) {

    fun getAllFavorites(): Flow<List<GameDetails>>
        = rawgRepository.getFavoriteGames()


    fun addFavorite(gameDetails: GameDetails) : Boolean
        = rawgRepository.addGameToFavorites(gameDetails)


    fun removeFavorite(gameDetails: GameDetails) : Boolean
        = rawgRepository.removeGameFromFavorites(gameDetails)


    fun isFavorite(id: Int): Boolean
        = rawgRepository.isFavorite(id)

}