package com.farifam.siwasis.holder

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.farifam.siwasis.BlokActivity
import com.farifam.siwasis.model.Blok
import kotlinx.android.synthetic.main.item_blok.view.*

class BlokHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val txtLabel = itemView.txtLabel
    private val txtDesc = itemView.txtDesc

    fun bindData(blok: Blok) {
        txtLabel.text = blok.name
        txtDesc.text = blok.deskripsi


        itemView.setOnClickListener { v: View  ->
//            var position: Int = getAdapterPosition()

            val intent = Intent(itemView.context, BlokActivity::class.java)
            itemView.context.startActivity(intent)
        }
    }
}
