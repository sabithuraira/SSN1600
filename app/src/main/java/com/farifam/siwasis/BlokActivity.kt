package com.farifam.siwasis

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.farifam.siwasis.model.Question

import kotlinx.android.synthetic.main.activity_blok.*
import java.io.IOException
import java.io.InputStream
import com.google.gson.Gson
import com.google.gson.JsonParser
import com.farifam.siwasis.adapter.QuestionAdapter
import kotlinx.android.synthetic.main.content_blok.*


class BlokActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blok)
        setSupportActionBar(toolbar)

        (this as AppCompatActivity).supportActionBar!!.title = intent.getStringExtra("nama")
        (this as AppCompatActivity).supportActionBar!!.subtitle = intent.getStringExtra("deskripsi")

        val listDatas: MutableList<Question> = mutableListOf()

        val parser = JsonParser()
        val jsonData =  inputStreamToString(this.getResources().openRawResource(R.raw.rule_sm2))

        val gson = Gson()

        val jsonTree = parser.parse(jsonData)
        val jsonObject = jsonTree.asJsonObject

        val blok_data = jsonObject.get("blok"+intent.getStringExtra("blok_id"))
        page_name.text = intent.getStringExtra("pesan")
        val datasets = gson.fromJson(blok_data,  Array<Question>::class.java) //Question::class.java)

        datasets.forEach {
            listDatas.add(it)
        }

        val heroesAdapter = QuestionAdapter(listDatas, this)

        rec_view.apply {
            layoutManager = LinearLayoutManager(this@BlokActivity)
            adapter = heroesAdapter
        }
    }

//    fun addMessage(message : String){
//        list_message.add(message)
//        val adapterMessage = MessageAdapter(list_message)
//
//        rec_view2.apply {
//            layoutManager = LinearLayoutManager(this@BlokActivity)
//            adapter = adapterMessage
//        }
//    }

    fun inputStreamToString(inputStream: InputStream): String {
        return try {
            val bytes = ByteArray(inputStream.available())
            inputStream.read(bytes, 0, bytes.size)
            return String(bytes)
        } catch (e: IOException) {
            ""
        }
    }
}
