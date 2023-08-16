package com.example.perqaragames.domain.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.perqaragames.core.constants.DISCOVER_PAGE_SIZE
import com.example.perqaragames.data.local.database.dao.FavoritesDao
import com.example.perqaragames.data.remote.RawgAPIService
import com.example.perqaragames.data.remote.dto.game.GamesResponse
import com.example.perqaragames.data.remote.dto.game_details.GameDetailsResponse
import com.example.perqaragames.data.remote.dto.game_screenshots.GameScreenShotResponse
import com.example.perqaragames.data.remote.dto.genre.GenresResponse
import com.example.perqaragames.data.remote.sources.BestOfAllTimePagingSource
import com.example.perqaragames.data.repository.RawgRepository
import com.example.perqaragames.domain.model.Game
import com.example.perqaragames.domain.model.GameDetails
import com.example.perqaragames.domain.model.GameQueries
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class RawgRepositoryImpl @Inject constructor(
    private val rawgApiService: RawgAPIService,
    private val favoritesDao: FavoritesDao
) : RawgRepository {

    override suspend fun getGenres(page: Int?, pageSize: Int?, ordering: String?): GenresResponse {
        return rawgApiService.getGenres(
            page = page,
            pageSize = pageSize,
            ordering = ordering
        )
    }

    override suspend fun getGames(
        gameQueries: GameQueries,
    ): GamesResponse {
        return rawgApiService.getGames(
            page = gameQueries.page,
            pageSize = gameQueries.pageSize,
            search = gameQueries.search,
            parentPlatforms = gameQueries.parentPlatforms,
            genres = gameQueries.genres,
            platforms = gameQueries.platforms,
            stores = gameQueries.stores,
            developers = gameQueries.developers,
            publishers = gameQueries.publishers,
            tags = gameQueries.tags,
            dates = gameQueries.dates,
            ordering = gameQueries.ordering
        )
    }

    override fun getBestOfAllTimeWithPagination(): Flow<PagingData<Game>> {
        return Pager(
            config = PagingConfig(
                pageSize = DISCOVER_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                BestOfAllTimePagingSource(rawgApiService)
            }
        ).flow
    }

    override suspend fun getGameDetails(id: Int): GameDetailsResponse {
        return rawgApiService.getGameDetails(id)
    }

    override suspend fun getGameScreenshots(id: Int): GameScreenShotResponse {
        return rawgApiService.getGameScreenshots(id)
    }

    override fun addGameToFavorites(gameDetails: GameDetails): Boolean {
        val effected =  favoritesDao.insertFavorite(gameDetails)
        return effected > 0
    }

    override fun removeGameFromFavorites(gameDetails: GameDetails): Boolean {
        val effected = favoritesDao.deleteFavorite(gameDetails.id)
        return effected > 0
    }

    override fun getFavoriteGames(): Flow<List<GameDetails>> {
        return favoritesDao.getAllFavorites()
    }

    override fun isFavorite(id: Int): Boolean {
        return favoritesDao.isFavorite(id)
    }
}