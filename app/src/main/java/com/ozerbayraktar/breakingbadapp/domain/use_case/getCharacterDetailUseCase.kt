package com.ozerbayraktar.breakingbadapp.domain.use_case

import com.ozerbayraktar.breakingbadapp.domain.repository.BreakingBadRepository
import javax.inject.Inject

class getCharacterDetailUseCase @Inject constructor(
    private val repository: BreakingBadRepository
) {
    suspend operator fun invoke(id: Int) = repository.getCharacterDetail(id)

}