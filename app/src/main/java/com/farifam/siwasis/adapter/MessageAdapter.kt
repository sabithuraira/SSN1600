package com.farifam.siwasis.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.farifam.siwasis.R
import com.farifam.siwasis.holder.MessageHolder


class MessageAdapter(private val datas: List<String>) : RecyclerView.Adapter<MessageHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): MessageHolder {
        return MessageHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.item_message, viewGroup, false))
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: MessageHolder, position: Int) {
        holder.bindData(datas[position])
    }
}
