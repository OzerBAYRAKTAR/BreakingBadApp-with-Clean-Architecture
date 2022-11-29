package com.ozerbayraktar.breakingbadapp.ui.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozerbayraktar.breakingbadapp.R
import com.ozerbayraktar.breakingbadapp.databinding.FragmentQuoteListBinding
import com.ozerbayraktar.breakingbadapp.domain.model.EpisodesUI
import com.ozerbayraktar.breakingbadapp.domain.model.QuotesUI
import com.ozerbayraktar.breakingbadapp.ui.adapter.EpisodesAdapter
import com.ozerbayraktar.breakingbadapp.ui.adapter.QuotesAdapter
import com.ozerbayraktar.breakingbadapp.ui.viewmodel.QuoteViewModel
import com.ozerbayraktar.breakingbadapp.util.LoadingScreen
import com.ozerbayraktar.breakingbadapp.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuoteList : Fragment(R.layout.fragment_quote_list) {

    private lateinit var viewModel:QuoteViewModel
    private var fragmentBinding:FragmentQuoteListBinding?=null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding=FragmentQuoteListBinding.bind(view)
        fragmentBinding=binding

        viewModel=ViewModelProvider(requireActivity()).get(QuoteViewModel::class.java)



        collectData()
    }

    private fun collectData() {
        with(viewModel) {
            viewLifecycleOwner.lifecycleScope.launchWhenStarted {
                state.collect { response ->
                    when (response) {
                        is Resource.Loading -> {
                            LoadingScreen.displayLoadingWithText(
                                requireContext(),
                                resources.getString(R.string.please_wait),
                                false
                            )
                        }
                        is Resource.Success -> {
                            LoadingScreen.hideLoading()
                            val quotesAdapter =
                                QuotesAdapter(response.data as ArrayList<QuotesUI>)
                            fragmentBinding!!.recyclerQuote.adapter = quotesAdapter

                            fragmentBinding!!.recyclerQuote.layoutManager =
                                LinearLayoutManager(requireActivity())
                            fragmentBinding!!.recyclerQuote.setHasFixedSize(true)
                        }
                        is Resource.Error -> {
                            LoadingScreen.hideLoading()
                            Log.e("Resource", response.throwable.localizedMessage ?: "")
                        }
                    }

                }

            }
        }
    }

}