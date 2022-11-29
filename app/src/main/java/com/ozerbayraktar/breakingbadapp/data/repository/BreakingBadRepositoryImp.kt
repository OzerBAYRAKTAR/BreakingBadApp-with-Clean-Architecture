package com.ozerbayraktar.breakingbadapp.data.repository

import com.ozerbayraktar.breakingbadapp.data.mapper.toCharacterDetailUI
import com.ozerbayraktar.breakingbadapp.data.mapper.toCharacterUI
import com.ozerbayraktar.breakingbadapp.data.mapper.toEpisodeUI
import com.ozerbayraktar.breakingbadapp.data.mapper.toQuotesUI
import com.ozerbayraktar.breakingbadapp.domain.model.CharacterDetailUI
import com.ozerbayraktar.breakingbadapp.domain.model.CharacterUI
import com.ozerbayraktar.breakingbadapp.domain.model.EpisodesUI
import com.ozerbayraktar.breakingbadapp.domain.model.QuotesUI
import com.ozerbayraktar.breakingbadapp.domain.repository.BreakingBadRepository
import com.ozerbayraktar.breakingbadapp.domain.source.RemoteDataSource
import com.ozerbayraktar.breakingbadapp.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BreakingBadRepositoryImp(
    private val remoteDataSource: RemoteDataSource
): BreakingBadRepository {
    override suspend fun getCharacters(): Flow<Resource<List<CharacterUI>>> = flow {
        emit(Resource.Loading)
        try {
            emit(
                Resource.Success(remoteDataSource.getcharacters()
                    .map { it.toCharacterUI() })
            )

        } catch (e: Exception) {
            emit(Resource.Error(e))

        }

    }

    override suspend fun getEpisodes(): Flow<Resource<List<EpisodesUI>>> = flow{
        emit(Resource.Loading)
        try {
            emit(
                Resource.Success(remoteDataSource.getepisodes()
                    .map { it.toEpisodeUI() })
            )

        } catch (e: Exception) {
            emit(Resource.Error(e))
        }


    }

    override suspend fun getQuotes(): Flow<Resource<List<QuotesUI>>> = flow{
        emit(Resource.Loading)
        try {
            emit(
                Resource.Success(remoteDataSource.getquotes()
                    .map { it.toQuotesUI() })
            )

        } catch (e: Exception) {
            emit(Resource.Error(e))
        }

    }

    override suspend fun getCharacterDetail(id:Int): Flow<Resource<CharacterDetailUI>> = flow{
        emit(Resource.Loading)
        try {
            emit(
                Resource.Success(
                remoteDataSource.getCharacterDetail(id)[0].toCharacterDetailUI()
                )
            )

        } catch (e: Exception) {
            emit(Resource.Error(e))
        }

    }

    override suspend fun getEpisodeDetail(id:Int): Flow<Resource<EpisodesUI>> = flow{
        emit(Resource.Loading)
        try {
            emit(
                Resource.Success(remoteDataSource.getEpisodeDetail(id).toEpisodeUI())
                )

        }catch (e: Exception) {
            emit(Resource.Error(e))
        }

    }

}