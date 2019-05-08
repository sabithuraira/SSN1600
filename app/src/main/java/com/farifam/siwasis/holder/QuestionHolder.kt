package com.farifam.siwasis.holder

import android.view.View
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.farifam.siwasis.model.Question
import kotlinx.android.synthetic.main.item_question.view.*
import android.widget.ArrayAdapter
import androidx.core.view.accessibility.AccessibilityEventCompat.setAction
import com.google.android.material.snackbar.Snackbar

class QuestionHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val txtLabel = itemView.txtLabel
    val spinner1 = itemView.spinner1

    fun bindData(question: Question) {
        txtLabel.text = question.question

        val list = ArrayList<String>()

        list.add("- Pilih -")
        for (data in question.answer) {
            list.add(data.label)
        }

        val dataAdapter = ArrayAdapter<String>(
            itemView.context,
            android.R.layout.simple_spinner_item, list
        )

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner1?.setAdapter(dataAdapter)
        spinner1?.prompt = "- Pilih jawaban -"
//
//        spinner1?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//            }
//
//            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                if(question.answer[position].action=="next"){
//                    bindData(question.answer[position].next_action!!)
//                }
//            }
//        }

//        txtDesc.text = question.question

//        itemView.setOnClickListener { v: View  ->
//            var position: Int = getAdapterPosition()
//        }
    }
}