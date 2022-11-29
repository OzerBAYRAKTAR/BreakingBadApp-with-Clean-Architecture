package com.ozerbayraktar.breakingbadapp.ui.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ozerbayraktar.breakingbadapp.R
import com.ozerbayraktar.breakingbadapp.databinding.FragmentCharacterListBinding
import com.ozerbayraktar.breakingbadapp.domain.model.CharacterUI
import com.ozerbayraktar.breakingbadapp.ui.adapter.CharactersAdapter
import com.ozerbayraktar.breakingbadapp.ui.viewmodel.CharacterViewModel
import com.ozerbayraktar.breakingbadapp.util.LoadingScreen

import com.ozerbayraktar.breakingbadapp.util.Resource

import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.filter

@AndroidEntryPoint
class CharacterList : Fragment(R.layout.fragment_character_list) {

    private lateinit var viewModel:CharacterViewModel
    private var fragmentBinding: FragmentCharacterListBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding=FragmentCharacterListBinding.bind(view)
        fragmentBinding=binding

        viewModel= ViewModelProvider(requireActivity()).get(CharacterViewModel::class.java)

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
                            val charactersAdapter =
                                CharactersAdapter(response.data as ArrayList<CharacterUI>)
                            fragmentBinding!!.recyclerCharacter.adapter = charactersAdapter
                            charactersAdapter.onClick = ::clickCharacter
                            fragmentBinding!!.breakingBadProggresBar.visibility=View.GONE
                            fragmentBinding!!.textError.visibility=View.GONE

                            fragmentBinding!!.recyclerCharacter.layoutManager =
                                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
                            fragmentBinding!!.recyclerCharacter.setHasFixedSize(true)
                        }
                        is Resource.Error -> {
                            LoadingScreen.hideLoading()
                            Log.e("Resource",  "")
                        }
                    }

                }

            }
        }
    }

    private fun clickCharacter(id: Int) {
        findNavController().navigate(
            CharacterListDirections.actionCharacterListToCharacterDetail(id)
        )
    }
}

