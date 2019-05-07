package com.farifam.siwasis.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.farifam.siwasis.R
import com.farifam.siwasis.holder.QuestionHolder
import com.farifam.siwasis.model.Question

class QuestionAdapter(private val datas: List<Question>) : RecyclerView.Adapter<QuestionHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): QuestionHolder {
        return QuestionHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.item_question, viewGroup, false))
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: QuestionHolder, position: Int) {
        holder.bindData(datas[position])
    }
}