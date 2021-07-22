package com.example.infosysexample.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.infosysexample.databinding.CardItemBinding
import com.example.infosysexample.dataclasses.CardG


//Most of this class is a fairly standard List Adapter typed to the apps custom CardG class
class CardsAdapter:ListAdapter<CardG, CardsAdapter.CardViewHolder>(DiffCallback) {
    class CardViewHolder(private var binding:CardItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(cardg:CardG){
            //actually binding our data
            binding.cardv=cardg
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback: DiffUtil.ItemCallback<CardG>(){
        override fun areItemsTheSame(oldItem: CardG, newItem: CardG)=oldItem===newItem

        //Done: TODO: figure out a equality check for content on final card version
        //I think the titles are unique, for the current data set they are
        //  this can be changed later if needed
        override fun areContentsTheSame(oldItem: CardG, newItem: CardG)=oldItem.card.title.value==newItem.card.title.value

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder(CardItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        //go bind the data we need
        holder.bind(getItem(position))
    }
}