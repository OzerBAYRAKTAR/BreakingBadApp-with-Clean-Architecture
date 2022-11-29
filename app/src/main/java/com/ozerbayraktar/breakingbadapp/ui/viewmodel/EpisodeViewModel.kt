package com.ozerbayraktar.breakingbadapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ozerbayraktar.breakingbadapp.data.model.EpisodesModel
import com.ozerbayraktar.breakingbadapp.domain.model.EpisodesUI
import com.ozerbayraktar.breakingbadapp.domain.repository.BreakingBadRepository
import com.ozerbayraktar.breakingbadapp.domain.use_case.GetEpisodeUseCase
import com.ozerbayraktar.breakingbadapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EpisodeViewModel @Inject constructor(
    private val getEpisodeUseCase: GetEpisodeUseCase
) : ViewModel(){

    private var _state= MutableStateFlow<Resource<List<EpisodesUI>>>(Resource.Loading)
    var state=_state.asStateFlow()


    init {
        getEpisodes()
    }

    private fun getEpisodes()=viewModelScope.launch {
        getEpisodeUseCase().collect {
        _state.emit(it)
        }
    }
}