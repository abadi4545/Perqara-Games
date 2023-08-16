package com.example.perqaragames.domain.usecase

import com.example.perqaragames.data.Resource
import com.example.perqaragames.data.mapper.toGenreList
import com.example.perqaragames.data.repository.RawgRepository
import com.example.perqaragames.domain.model.Genre
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class GenreUseCases @Inject constructor(
    private val rawgRepository: RawgRepository
) {

    fun getAllCategories(): Flow<Resource<List<Genre>>> = flow {
        try {
            emit(Resource.Loading())

            val list: List<Genre> = rawgRepository
                .getGenres()
                .toGenreList()

            emit(Resource.Success(list))

        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }


}