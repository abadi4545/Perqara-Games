package com.example.perqaragames.data.remote.sources

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.perqaragames.core.constants.DISCOVER_PAGE_SIZE
import com.example.perqaragames.core.enums.GamesOrderType
import com.example.perqaragames.data.mapper.toGameList
import com.example.perqaragames.data.remote.RawgAPIService
import com.example.perqaragames.domain.model.Game
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BestOfAllTimePagingSource @Inject constructor(
    private val rawgApiService: RawgAPIService
) : PagingSource<Int, Game>() {

    override fun getRefreshKey(state: PagingState<Int, Game>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Game> {
        return try {
            val nextPageNumber = params.key ?: 1
            val response = withContext(Dispatchers.IO) {
                rawgApiService.getGames(
                    page = nextPageNumber,
                    pageSize = DISCOVER_PAGE_SIZE,
                    ordering = GamesOrderType.ADDED.reverse(),
                )
            }
            val games: List<Game> = response.toGameList()
            LoadResult.Page(
                data = games,
                prevKey = if (nextPageNumber == 1) null else nextPageNumber - 1,
                nextKey = if (games.isEmpty()) null else nextPageNumber + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }


}