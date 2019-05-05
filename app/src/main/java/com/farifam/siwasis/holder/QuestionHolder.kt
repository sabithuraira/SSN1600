package com.farifam.siwasis.holder

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.farifam.siwasis.BlokActivity
import com.farifam.siwasis.model.Question
import kotlinx.android.synthetic.main.item_blok.view.*

class QuestionHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val txtLabel = itemView.txtLabel
    private val txtDesc = itemView.txtDesc

    fun bindData(question: Question) {
        txtLabel.text = question.question
        txtDesc.text = question.question

//        itemView.setOnClickListener { v: View  ->
//            var position: Int = getAdapterPosition()
//        }
    }
}
