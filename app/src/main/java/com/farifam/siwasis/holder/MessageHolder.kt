package com.farifam.siwasis.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_message.view.*

class MessageHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val txtLabel = itemView.txtLabel

    fun bindData(pesan: String) {
        txtLabel.text = pesan
    }
}
