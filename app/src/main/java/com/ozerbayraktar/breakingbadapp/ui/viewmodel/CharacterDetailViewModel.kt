package com.ozerbayraktar.breakingbadapp.ui.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ozerbayraktar.breakingbadapp.data.model.CharacterModel
import com.ozerbayraktar.breakingbadapp.domain.model.CharacterDetailUI
import com.ozerbayraktar.breakingbadapp.domain.repository.BreakingBadRepository
import com.ozerbayraktar.breakingbadapp.domain.use_case.getCharacterDetailUseCase
import com.ozerbayraktar.breakingbadapp.util.Constans.PARAM_ID
import com.ozerbayraktar.breakingbadapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val getCharacterDetailUseCase: getCharacterDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel()  {
    private var _state = MutableStateFlow<Resource<CharacterDetailUI>>(Resource.Loading)
    val state = _state.asStateFlow()

    init {
        savedStateHandle.get<Int>(PARAM_ID)?.let { getCharacterDetail(it) }
    }



    private fun getCharacterDetail(id: Int) = viewModelScope.launch {
        getCharacterDetailUseCase(id).collect {
            _state.emit(it)
        }
    }

}