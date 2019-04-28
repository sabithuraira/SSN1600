package com.farifam.siwasis

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager
import com.farifam.siwasis.adapter.Blokdapter
import com.farifam.siwasis.model.Blok

import kotlinx.android.synthetic.main.activity_kewajaran.*
import kotlinx.android.synthetic.main.content_kewajaran.*
import kotlinx.android.synthetic.main.content_kewajaran.rec_view

class KewajaranActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kewajaran)
        setSupportActionBar(toolbar)

        val listHeroes = listOf(
            Blok(name = "BLOK I"),
            Blok(name = "BLOK II"),
            Blok(name = "BLOK III"),
            Blok(name = "BLOK IV"),
            Blok(name = "BLOK V"),
            Blok(name = "BLOK VI"),
            Blok(name = "BLOK VII")
        )

        val heroesAdapter = Blokdapter(listHeroes)

        rec_view.apply {
            layoutManager = LinearLayoutManager(this@KewajaranActivity)
            adapter = heroesAdapter
        }
    }

}
