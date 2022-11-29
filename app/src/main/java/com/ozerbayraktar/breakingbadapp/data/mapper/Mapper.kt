package com.ozerbayraktar.breakingbadapp.data.mapper

import com.ozerbayraktar.breakingbadapp.data.model.CharacterModel
import com.ozerbayraktar.breakingbadapp.data.model.EpisodesModel
import com.ozerbayraktar.breakingbadapp.data.model.QuotesModel
import com.ozerbayraktar.breakingbadapp.domain.model.CharacterDetailUI
import com.ozerbayraktar.breakingbadapp.domain.model.CharacterUI
import com.ozerbayraktar.breakingbadapp.domain.model.EpisodesUI
import com.ozerbayraktar.breakingbadapp.domain.model.QuotesUI



fun CharacterModel.toCharacterUI():CharacterUI{
    return CharacterUI(
        charId=charId,
        img=img,
        name=name
    )
}
fun EpisodesModel.toEpisodeUI(): EpisodesUI{
    return EpisodesUI(
        episodeId=episodeId,
        title = title
    )
}
fun CharacterModel.toCharacterDetailUI(): CharacterDetailUI {
    return CharacterDetailUI(
        appearance = appearance,
        birthday = birthday,
        category = category,
        charId = charId,
        img = img,
        name = name,
        nickname = nickname,
        occupation = occupation,
        portrayed = portrayed,
        status = status
    )
}
fun QuotesModel.toQuotesUI(): QuotesUI{
    return QuotesUI(
        author = author,
        quote = quote,
        series = series
    )
}