package com.ozerbayraktar.breakingbadapp.domain.source

import com.ozerbayraktar.breakingbadapp.data.model.CharacterModel
import com.ozerbayraktar.breakingbadapp.data.model.EpisodesModel
import com.ozerbayraktar.breakingbadapp.data.model.QuotesModel

interface RemoteDataSource {
    suspend fun getcharacters(): List<CharacterModel>
    suspend fun getepisodes(): List<EpisodesModel>
    suspend fun getquotes(): List<QuotesModel>
    suspend fun getCharacterDetail(id:Int): List<CharacterModel>
    suspend fun getEpisodeDetail(id:Int):EpisodesModel
}