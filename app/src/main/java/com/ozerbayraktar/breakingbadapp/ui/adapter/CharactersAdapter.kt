package com.ozerbayraktar.breakingbadapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ozerbayraktar.breakingbadapp.databinding.ItemCharacterBinding
import com.ozerbayraktar.breakingbadapp.domain.model.CharacterUI
import com.ozerbayraktar.breakingbadapp.util.glideImage

class CharactersAdapter(private var characterList:ArrayList<CharacterUI>):
    RecyclerView.Adapter<CharactersAdapter.ItemHolder>() {

      var onClick: (Int) -> Unit = {}


    inner class ItemHolder(private val binding:ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CharacterUI) {
            with(binding){
                with(item) {
                    characterText.text=name
                    characterImage.glideImage(img)
                    root.setOnClickListener {
                        onClick(charId) }

                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemBinding=
            ItemCharacterBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(characterList[position])
        }

    override fun getItemCount(): Int =characterList.size


}