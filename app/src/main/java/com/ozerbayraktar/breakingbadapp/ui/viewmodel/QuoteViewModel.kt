package com.ozerbayraktar.breakingbadapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ozerbayraktar.breakingbadapp.data.model.QuotesModel
import com.ozerbayraktar.breakingbadapp.domain.model.QuotesUI
import com.ozerbayraktar.breakingbadapp.domain.repository.BreakingBadRepository
import com.ozerbayraktar.breakingbadapp.domain.use_case.GetQuotesUseCase
import com.ozerbayraktar.breakingbadapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuotesUseCase: GetQuotesUseCase
): ViewModel() {


    private var _state=MutableStateFlow<Resource<List<QuotesUI>>>(Resource.Loading)
    var state=_state.asStateFlow()


    init{
        getQuotes()
    }

    private fun getQuotes()=viewModelScope.launch {
        getQuotesUseCase().collect{
            _state.emit(it)
        }
    }

}