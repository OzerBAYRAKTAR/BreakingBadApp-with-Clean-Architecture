package com.ozerbayraktar.breakingbadapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ozerbayraktar.breakingbadapp.data.model.EpisodesModel
import com.ozerbayraktar.breakingbadapp.databinding.ItemEpisodesBinding
import com.ozerbayraktar.breakingbadapp.domain.model.EpisodesUI

class EpisodesAdapter(private val episodeList:ArrayList<EpisodesUI>) :RecyclerView.Adapter<EpisodesAdapter.ItemHolder>(){

    inner class ItemHolder(private val binding:ItemEpisodesBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item :EpisodesUI){
            with(binding) {
                with(item) {
                    episodeRank.text=episodeId.toString()
                    episodeText.text=title
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val binding =
            ItemEpisodesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(episodeList[position])
    }

    override fun getItemCount(): Int {
        return episodeList.size
    }
}