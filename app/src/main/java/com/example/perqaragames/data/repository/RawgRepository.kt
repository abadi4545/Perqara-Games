package com.example.perqaragames.data.repository

import androidx.paging.PagingData
import com.example.perqaragames.data.remote.dto.game.GamesResponse
import com.example.perqaragames.data.remote.dto.game_details.GameDetailsResponse
import com.example.perqaragames.data.remote.dto.game_screenshots.GameScreenShotResponse
import com.example.perqaragames.data.remote.dto.genre.GenresResponse
import com.example.perqaragames.domain.model.Game
import com.example.perqaragames.domain.model.GameDetails
import com.example.perqaragames.domain.model.GameQueries
import kotlinx.coroutines.flow.Flow

interface RawgRepository {

    suspend fun getGenres(
        page: Int? = null,
        pageSize: Int? = null,
        ordering: String? = null,
    ): GenresResponse


    suspend fun getGames(
        gameQueries: GameQueries,
    ): GamesResponse

    suspend fun getGameDetails(id: Int): GameDetailsResponse

    suspend fun getGameScreenshots(id: Int): GameScreenShotResponse

    fun getBestOfAllTimeWithPagination(): Flow<PagingData<Game>>


    fun addGameToFavorites(gameDetails: GameDetails) : Boolean

    fun removeGameFromFavorites(gameDetails: GameDetails) : Boolean

    fun getFavoriteGames(): Flow<List<GameDetails>>

    fun isFavorite(id: Int): Boolean

}