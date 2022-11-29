package com.ozerbayraktar.breakingbadapp.data.model

import com.google.gson.annotations.SerializedName

data class EpisodesModel (

    @SerializedName("episode_id")
    val episodeId:Int,
    val title:String,
    val season:String,
    @SerializedName("air_date")
    val airDate:String,
    val characters:List<String>,
    val episode:String,
    val series:String
)