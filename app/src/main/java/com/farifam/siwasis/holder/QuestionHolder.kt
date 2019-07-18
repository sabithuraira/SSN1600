package com.farifam.siwasis.holder

import android.view.View
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.farifam.siwasis.model.Question
import kotlinx.android.synthetic.main.item_question.view.*
import android.widget.ArrayAdapter
import androidx.core.view.accessibility.AccessibilityEventCompat.setAction
import androidx.recyclerview.widget.LinearLayoutManager
import com.farifam.siwasis.adapter.MessageAdapter
import com.google.android.material.snackbar.Snackbar

class QuestionHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val txtLabel = itemView.txtLabel
    val spinner1 = itemView.spinner1
    val rec_message = itemView.rec_message

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
        spinner1?.setSelection(question.selected_val, false)

        var adapterMessage = MessageAdapter(emptyList())
        if(!question.confirm_answer.isNullOrEmpty()) {
            adapterMessage = MessageAdapter(question.confirm_answer)
        }

        rec_message.apply {
            layoutManager = LinearLayoutManager(itemView.context)
            adapter = adapterMessage
        }
    }
}