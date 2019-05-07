package com.farifam.siwasis.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.farifam.siwasis.model.Question
import kotlinx.android.synthetic.main.item_question.view.*
import android.widget.ArrayAdapter

class QuestionHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val txtLabel = itemView.txtLabel
    private val spinner1 = itemView.spinner1

    fun bindData(question: Question) {
        txtLabel.text = question.question

        val list = ArrayList<String>()

        for (data in question.answer) {
            list.add(data.label)
        }

        val dataAdapter = ArrayAdapter<String>(
            itemView.context,
            android.R.layout.simple_spinner_item, list
        )

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner1.setAdapter(dataAdapter)

//        txtDesc.text = question.question

//        itemView.setOnClickListener { v: View  ->
//            var position: Int = getAdapterPosition()
//        }
    }
}