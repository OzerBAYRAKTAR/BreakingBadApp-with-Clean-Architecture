package com.ozerbayraktar.breakingbadapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.ozerbayraktar.breakingbadapp.domain.model.CharacterUI
import com.ozerbayraktar.breakingbadapp.domain.use_case.GetCharacterUseCase
import com.ozerbayraktar.breakingbadapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharacterUseCase
) : ViewModel() {


    private var _state = MutableStateFlow<Resource<List<CharacterUI>>>(Resource.Loading)
    var state=_state.asStateFlow()

    init {
        getCharacter()

    }

    private fun getCharacter() =viewModelScope.launch {
        getCharactersUseCase().collect{
            _state.emit(it)

        }
    }

}

