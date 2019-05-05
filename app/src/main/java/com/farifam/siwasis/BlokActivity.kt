package com.farifam.siwasis

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager
import com.farifam.siwasis.adapter.BlokAdapter
import com.farifam.siwasis.model.Question

import kotlinx.android.synthetic.main.activity_blok.*
import java.io.IOException
import java.io.InputStream
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonParser
import android.service.autofill.Dataset
import com.google.gson.reflect.TypeToken
import java.lang.Exception


class BlokActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blok)
        setSupportActionBar(toolbar)

//        try {
//            val inputStream: InputStream = assets.open("news_data_file.json")
//            val inputStreamReader = InputStreamReader(inputStream)
//            val sb = StringBuilder()
//            var line: String?
//            val br = BufferedReader(inputStreamReader)
//            line = br.readLine()
//            while (br.readLine() != null) {
//                sb.append(line)
//                line = br.readLine()
//            }
//            br.close()
//            Log.d(TAG,sb.toString())
//        } catch (e:Exception){
//            Log.d(TAG, e.toString())
//        }

        val listDatas: MutableList<Question> = mutableListOf()

        val parser = JsonParser()
        val jsonData =  inputStreamToString(this.getResources().openRawResource(R.raw.rule))

//        val jsonTree = parser.parse(json_data)
//        val jsonObject = jsonTree.asJsonObject

//        val blok_data = jsonObject.get("blokvi")

        val gson = Gson()
        val datasetListType = object : TypeToken<Collection<Question>>() {}.type
        val datasets = gson.fromJson(jsonData, datasetListType)

//        if(jsonTree.isJsonArray()){
//            listDatas.add(Question("answer": ))
//        }

//        val myModel = Gson().fromJson(myJson, MyModel::class.java)

//
//        val heroesAdapter = BlokAdapter(listDatas)
//
//        rec_view.apply {
//            layoutManager = LinearLayoutManager(this@BlokActivity)
//            adapter = heroesAdapter
//        }
    }

    fun inputStreamToString(inputStream: InputStream): String {
        try {
            val bytes = ByteArray(inputStream.available())
            inputStream.read(bytes, 0, bytes.size)
            return String(bytes)
        } catch (e: IOException) {
            null
        }
    }

}
