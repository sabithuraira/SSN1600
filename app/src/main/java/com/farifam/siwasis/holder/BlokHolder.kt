package com.farifam.siwasis.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.farifam.siwasis.model.Blok
import kotlinx.android.synthetic.main.item_blok.view.*

class BlokHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val txtLabel = view.txtLabel

    fun bindHero(blok: Blok) {
        txtLabel.text = blok.name
    }
}
