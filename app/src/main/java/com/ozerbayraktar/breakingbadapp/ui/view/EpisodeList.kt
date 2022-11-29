package com.ozerbayraktar.breakingbadapp.ui.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ozerbayraktar.breakingbadapp.R
import com.ozerbayraktar.breakingbadapp.databinding.FragmentEpisodeListBinding
import com.ozerbayraktar.breakingbadapp.domain.model.CharacterUI
import com.ozerbayraktar.breakingbadapp.domain.model.EpisodesUI
import com.ozerbayraktar.breakingbadapp.ui.adapter.CharactersAdapter
import com.ozerbayraktar.breakingbadapp.ui.adapter.EpisodesAdapter
import com.ozerbayraktar.breakingbadapp.ui.viewmodel.EpisodeViewModel
import com.ozerbayraktar.breakingbadapp.util.LoadingScreen
import com.ozerbayraktar.breakingbadapp.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EpisodeList : Fragment(R.layout.fragment_episode_list) {

    private lateinit var viewModel: EpisodeViewModel
    private var fragmentBinding: FragmentEpisodeListBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding=FragmentEpisodeListBinding.bind(view)
        fragmentBinding=binding

        viewModel=ViewModelProvider(requireActivity()).get(EpisodeViewModel::class.java)

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
                            val episodesAdapter =
                                EpisodesAdapter(response.data as ArrayList<EpisodesUI>)
                            fragmentBinding!!.recyclerEpisode.adapter = episodesAdapter

                            fragmentBinding!!.recyclerEpisode.layoutManager =
                                LinearLayoutManager(requireActivity())
                            fragmentBinding!!.recyclerEpisode.setHasFixedSize(true)
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