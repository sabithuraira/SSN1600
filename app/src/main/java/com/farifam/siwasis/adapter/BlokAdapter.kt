package com.farifam.siwasis.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.farifam.siwasis.R
import com.farifam.siwasis.holder.BlokHolder
import com.farifam.siwasis.model.Blok

class Blokdapter(private val heroes: List<Blok>) : RecyclerView.Adapter<BlokHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): BlokHolder {
        return BlokHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.item_blok, viewGroup, false))
    }

    override fun getItemCount(): Int = heroes.size

    override fun onBindViewHolder(holder: BlokHolder, position: Int) {
        holder.bindHero(heroes[position])
    }
}
