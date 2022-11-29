package com.ozerbayraktar.breakingbadapp.data.source

import com.ozerbayraktar.breakingbadapp.data.model.CharacterModel
import com.ozerbayraktar.breakingbadapp.data.model.EpisodesModel
import com.ozerbayraktar.breakingbadapp.data.model.QuotesModel
import com.ozerbayraktar.breakingbadapp.util.Constans.CHARACTERS
import com.ozerbayraktar.breakingbadapp.util.Constans.CHARACTERS_DETAIL
import com.ozerbayraktar.breakingbadapp.util.Constans.EPISODES
import com.ozerbayraktar.breakingbadapp.util.Constans.EPISODES_DETAIL
import com.ozerbayraktar.breakingbadapp.util.Constans.QUOTES
import retrofit2.http.GET
import retrofit2.http.Path

interface BreakingBadApiService {
    @GET(CHARACTERS)
    suspend fun getCharacters(): List<CharacterModel>

    @GET(EPISODES)
    suspend fun getEpisodes(): List<EpisodesModel>

    @GET(QUOTES)
    suspend fun getQuotes(): List<QuotesModel>

    @GET(EPISODES_DETAIL)
    suspend fun getEpisodeDetail(@Path("id") id:Int): EpisodesModel

    @GET(CHARACTERS_DETAIL)
    suspend fun getCharacterDetail(@Path("id") id: Int): List<CharacterModel>


}