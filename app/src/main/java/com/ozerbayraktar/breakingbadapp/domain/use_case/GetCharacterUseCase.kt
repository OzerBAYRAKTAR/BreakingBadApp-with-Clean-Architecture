package com.ozerbayraktar.breakingbadapp.domain.use_case

import com.ozerbayraktar.breakingbadapp.domain.repository.BreakingBadRepository
import javax.inject.Inject

class GetCharacterUseCase @Inject constructor(
    private val repository: BreakingBadRepository
) {

    suspend operator fun invoke() = repository.getCharacters()

}