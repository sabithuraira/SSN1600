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
            Blok(id="i", name = "BLOK I", deskripsi =  "Keterangan Tempat", pesan = ""),
            Blok(id="ii", name = "BLOK II", deskripsi =  "Keterangan Pencacahan", pesan = ""),
            Blok(id="iii", name = "BLOK III", deskripsi =  "Keterangan Ringkasa", pesan = ""),
            Blok(id="iv", name = "BLOK IV", deskripsi =  "Keterangan Demografi", pesan = ""),
            Blok(id="v", name = "BLOK V", deskripsi =  "Keterangan Nomor Induk Kependudukan", pesan = ""),
            Blok(id="vi", name = "BLOK VI", deskripsi =  "Keterangan Migrasi, Akta Kelahiran, dan Pendidikan",
                pesan = "Cek keseuaian Nama Provinsi/Negara dan Kode Kabupaten/kota"),
            Blok(id="vii", name = "BLOK VII", deskripsi =  "Keterangan Ketenagakerjaan (Untuk Anggota Rumah Tangga Berumur 10 Tahun ke atas)",
                pesan = "Cek Isian Blok VII hanya untuk ART 10 Tahun Keatas -- Cek kolom 401 dilingkari"),
            Blok(id="viii", name = "BLOK VIII", deskripsi =  "Keterangan Teknologi Informasi, Komunikasi, dan Kepemilikan Tabungan(Untuk Anggota Rumah Tangga Berumur 5 Tahun ke atas",
                pesan = "Cek Isian Blok VII hanya untuk ART 5 Tahun Keatas -- Cek kolom 401 dilingkari ART 5 tahun keatas"),
            Blok(id="ix", name = "BLOK IX", deskripsi =  "Keterangan Korban Kejahatan",
                pesan = "Cek Isian Keterangan korban kejahatan, jika ada 1 (satu) ART jadi korban beberapa kejadian, konfirmasi ke petugas apakah benar berlainan rangkaian kejadian"),
            Blok(id="x", name = "BLOK X", deskripsi =  "Keterangan Gangguan Fungsional (Untuk ART Berumur 2 Tahun ke atas",
                pesan = "Cek isian Blok X hanya untuk ART 2 tahun keatas -- cek kolom 401 dilingkari dan R.1001 = 1 untuk ART 2 tahun keatas"),
            Blok(id="xi", name = "BLOK XI", deskripsi =  "Keterangan Keluhan Kesehatan dan Berobat Jalan",
                pesan = "Cek isian blok XI untuk semua ART"),
            Blok(id="xii", name = "BLOK XII", deskripsi =  "Keterangan Rawat Inap dan Merokok",
                pesan = "Cek isian blok XII, Rincian 1201 - 1204 untuk semua umur, dan 1205 - 1208 untuk 5 tahun keatas"),
            Blok(id="xiii", name = "BLOK XIII", deskripsi =  "Keterangan Pemanfaatan Jaminan Kesehatan",
                pesan = "Cek isian blok XIII untuk semua ART, kesesuaian R.1301 dan R.1101"),
            Blok(id="xiv", name = "BLOK XIV", deskripsi =  "Keterangan Imunisasi, ASI, dan MP-ASI (Ditanyakan Untuk Semua ART Umur 0 - 59 Bulan)",
                pesan = "Cek Isian Blok XIV hanya untukBalita (0-59 Bulan). Cek Imunisasi sesuai dengan kewajaran umur balita (0 - 59 bulan), jenis imunisasi, dan alur isian kuesioner"),
            Blok(id="xv", name = "BLOK XV", deskripsi =  "Penolong Persalinan",
                pesan = "Cek isian Blok XV untuk semua perempuan pernah kawin usia 10 - 54 tahun"),
            Blok(id="xvi", name = "BLOK XVI", deskripsi =  "Keluarga Berencana",
                pesan = "Cek isian Blok XVI untuk semua perempuan pernah kawin usia 10 - 54 tahun"),
            Blok(id="xvii", name = "BLOK XVII", deskripsi =  "Akses Terhadap Makanan (Ditanyakan pada KRT/Pasangan/ART 15 Tahun ke atas)",
                pesan = "Cek isian  Blok XVII no. Pemberi Informasi sudah benar"),
            Blok(id="xviii", name = "BLOK XVIII", deskripsi =  "Keterangan Perumahan", pesan = ""),
            Blok(id="xix", name = "BLOK XIX", deskripsi =  "Akses Terhadap Layanan Keuangan", pesan = ""),
            Blok(id="xx", name = "BLOK XX", deskripsi =  "Keterangan Kepemilikan Barang", pesan = ""),
            Blok(id="xxi", name = "BLOK XXI", deskripsi =  "Keterangan Perlindungan Sosial", pesan = ""),
            Blok(id="xxii", name = "BLOK XXII", deskripsi =  "Keterangan Sumber Penghasilan Rumah Tangga", pesan = ""),
            Blok(id="xxiii", name = "BLOK XXIII", deskripsi =  "Catatan", pesan = "")
        )

        val heroesAdapter = BlokAdapter(listHeroes)

        rec_view.apply {
            layoutManager = LinearLayoutManager(this@KewajaranActivity)
            adapter = heroesAdapter
        }
    }

}
