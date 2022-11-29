package com.ozerbayraktar.breakingbadapp.domain.repository

import com.ozerbayraktar.breakingbadapp.domain.model.CharacterDetailUI
import com.ozerbayraktar.breakingbadapp.domain.model.CharacterUI
import com.ozerbayraktar.breakingbadapp.domain.model.EpisodesUI
import com.ozerbayraktar.breakingbadapp.domain.model.QuotesUI
import com.ozerbayraktar.breakingbadapp.util.Resource
import kotlinx.coroutines.flow.Flow

interface BreakingBadRepository {
    suspend fun getCharacters(): Flow<Resource<List<CharacterUI>>>
    suspend fun getEpisodes(): Flow<Resource<List<EpisodesUI>>>
    suspend fun getQuotes(): Flow<Resource<List<QuotesUI>>>
    suspend fun getCharacterDetail(id: Int): Flow<Resource<CharacterDetailUI>>
    suspend fun getEpisodeDetail(id:Int): Flow<Resource<EpisodesUI>>

}