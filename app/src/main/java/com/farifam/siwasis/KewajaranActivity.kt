package com.farifam.siwasis

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager
import com.farifam.siwasis.adapter.BlokAdapter
import com.farifam.siwasis.model.Blok

import kotlinx.android.synthetic.main.activity_kewajaran.*
import kotlinx.android.synthetic.main.content_kewajaran.rec_view

class KewajaranActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kewajaran)
        setSupportActionBar(toolbar)

        val listHeroes = listOf(
            Blok(id="i", name = "BLOK I", deskripsi =  "Keterangan Tempat"),
            Blok(id="ii", name = "BLOK II", deskripsi =  "Keterangan Tempat"),
            Blok(id="iii", name = "BLOK III", deskripsi =  "Keterangan Tempat"),
            Blok(id="iv", name = "BLOK IV", deskripsi =  "Keterangan Tempat"),
            Blok(id="v", name = "BLOK V", deskripsi =  "Keterangan Tempat"),
            Blok(id="vi", name = "BLOK VI", deskripsi =  "Keterangan Tempat"),
            Blok(id="vii", name = "BLOK VII", deskripsi =  "Keterangan Tempat"),
            Blok(id="viii", name = "BLOK VIII", deskripsi =  "Keterangan Tempat"),
            Blok(id="ix", name = "BLOK IX", deskripsi =  "Keterangan Tempat"),
            Blok(id="x", name = "BLOK X", deskripsi =  "Keterangan Tempat")
        )

        val heroesAdapter = BlokAdapter(listHeroes)

        rec_view.apply {
            layoutManager = LinearLayoutManager(this@KewajaranActivity)
            adapter = heroesAdapter
        }
    }

}
