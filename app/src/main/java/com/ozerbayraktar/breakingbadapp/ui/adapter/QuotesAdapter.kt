package com.ozerbayraktar.breakingbadapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ozerbayraktar.breakingbadapp.data.model.QuotesModel
import com.ozerbayraktar.breakingbadapp.databinding.ItemQuotesBinding
import com.ozerbayraktar.breakingbadapp.domain.model.QuotesUI

class QuotesAdapter(private val quotesList:ArrayList<QuotesUI>):RecyclerView.Adapter<QuotesAdapter.ItemHolder>() {

    inner class ItemHolder(private val binding:ItemQuotesBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: QuotesUI) {
            with(binding) {
                with(item) {
                    quoteNick.text=author
                    quoteText.text=quote

                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val binding = ItemQuotesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(quotesList[position])
    }

    override fun getItemCount(): Int {
        return quotesList.size
    }
}