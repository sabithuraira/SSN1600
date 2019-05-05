package com.farifam.siwasis

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager
import com.farifam.siwasis.adapter.BlokAdapter
import com.farifam.siwasis.model.Blok

import kotlinx.android.synthetic.main.activity_blok.*
import kotlinx.android.synthetic.main.content_kewajaran.*

class BlokActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blok)
        setSupportActionBar(toolbar)

        val listHeroes = listOf(
            Question(name = "BLOK I", deskripsi =  "Keterangan Tempat")
        )

        val heroesAdapter = BlokAdapter(listHeroes)

        rec_view.apply {
            layoutManager = LinearLayoutManager(this@BlokActivity)
            adapter = heroesAdapter
        }
    }

}
