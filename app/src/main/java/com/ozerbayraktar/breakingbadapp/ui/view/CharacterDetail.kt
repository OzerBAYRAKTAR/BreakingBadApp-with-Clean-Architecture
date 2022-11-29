package com.ozerbayraktar.breakingbadapp.ui.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.ozerbayraktar.breakingbadapp.R
import com.ozerbayraktar.breakingbadapp.databinding.FragmentCharacterDetailBinding
import com.ozerbayraktar.breakingbadapp.ui.viewmodel.CharacterDetailViewModel
import com.ozerbayraktar.breakingbadapp.util.LoadingScreen
import com.ozerbayraktar.breakingbadapp.util.Resource
import com.ozerbayraktar.breakingbadapp.util.glideImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetail : Fragment(R.layout.fragment_character_detail) {

    private  val viewModel: CharacterDetailViewModel by viewModels()
    private var fragmentBinding: FragmentCharacterDetailBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentCharacterDetailBinding.bind(view)
        fragmentBinding = binding


        collectData()
    }

    private fun collectData() {
        with(viewModel) {
            viewLifecycleOwner.lifecycleScope.launchWhenStarted {
                state.collect { response ->
                    when (response) {
                        is Resource.Loading -> {
                            LoadingScreen.displayLoadingWithText(
                                requireContext(), resources.getString(R.string.please_wait), false
                            )
                        }
                            is Resource.Success -> {
                                LoadingScreen.hideLoading()
                                //with(fragmentBinding) {
                                    with(response.data) {
                                        fragmentBinding!!.detailImage.glideImage(img)
                                        fragmentBinding!!.detName.text = "Name:    $name"
                                        fragmentBinding!!.detNick.text = "NickName:    $nickname"
                                        fragmentBinding!!.detPortrayed.text = "Portrayed:    $portrayed"
                                        fragmentBinding!!.detOccup.text = "Occupation:    ${occupation.joinToString()}"
                                        fragmentBinding!!.detAppear.text = "Appearance:    ${appearance.joinToString()}"
                                        fragmentBinding!!.detStatus.text = "Status:    $status"
                                    }
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
    }


