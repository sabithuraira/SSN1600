package com.farifam.siwasis.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.farifam.siwasis.BlokActivity
import com.farifam.siwasis.R
import com.farifam.siwasis.holder.QuestionHolder
import com.farifam.siwasis.model.Question
import android.content.Context


class QuestionAdapter(private var datas: MutableList<Question>,var mContext: Context) : RecyclerView.Adapter<QuestionHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): QuestionHolder {
        return QuestionHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.item_question, viewGroup, false))
    }

    override fun getItemCount(): Int = datas.size

    override fun onBindViewHolder(holder: QuestionHolder, position: Int) {
        holder.bindData(datas[position])

        holder.spinner1?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, c_position: Int, id: Long) {
                if(c_position>0) {
                    if (datas[position].answer[c_position - 1].action == "next") {
//                    bindData(question.answer[position].next_action!!)
                        datas.add((position + 1), datas[position].answer[c_position - 1].next_action!!)
                        notifyDataSetChanged()
                    }


                    for (data in datas[position].answer[c_position - 1].message) {
//                        list.add(data.label)
                        (mContext as BlokActivity).addMessage(data.toString())
                    }
                }
            }
        }
    }
}