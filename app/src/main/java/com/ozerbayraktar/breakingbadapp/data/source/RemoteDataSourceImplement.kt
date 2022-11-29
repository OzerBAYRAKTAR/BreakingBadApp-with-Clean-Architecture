package com.ozerbayraktar.breakingbadapp.data.source

import com.ozerbayraktar.breakingbadapp.data.model.CharacterModel
import com.ozerbayraktar.breakingbadapp.data.model.EpisodesModel
import com.ozerbayraktar.breakingbadapp.data.model.QuotesModel
import com.ozerbayraktar.breakingbadapp.domain.source.RemoteDataSource


class RemoteDataSourceImplement(
    private val remoteService:BreakingBadApiService): RemoteDataSource {
    override suspend fun getcharacters(): List<CharacterModel> {
        return remoteService.getCharacters()
    }

    override suspend fun getepisodes(): List<EpisodesModel> {
        return remoteService.getEpisodes()
    }

    override suspend fun getquotes(): List<QuotesModel> {
        return remoteService.getQuotes()
    }

    override suspend fun getCharacterDetail(id: Int): List<CharacterModel> {
        return remoteService.getCharacterDetail(id)
    }

    override suspend fun getEpisodeDetail(id: Int): EpisodesModel {
        return remoteService.getEpisodeDetail(id)
    }
}