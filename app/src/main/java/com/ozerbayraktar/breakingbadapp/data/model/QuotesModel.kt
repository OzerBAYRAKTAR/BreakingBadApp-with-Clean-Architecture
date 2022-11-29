package com.ozerbayraktar.breakingbadapp.data.model

import com.google.gson.annotations.SerializedName

data class QuotesModel(

    @SerializedName("quote_id")
    val quoteId:Int,
    val quote:String,
    val author:String,
    val series:String
)