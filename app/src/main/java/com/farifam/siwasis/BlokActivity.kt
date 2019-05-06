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

        val listDatas: MutableList<Question> = mutableListOf()

        val parser = JsonParser()
//        val jsonData =  inputStreamToString(this.getResources().openRawResource(R.raw.rule))

        val jsonData : String? = "{\n" +
                "  \"blokiv\": [{\n" +
                "    \"question\": \"Apakah ada Perempuan Usia 10 - 50 Tahun (Usia Subur)\",\n" +
                "    \"answer\": [{\n" +
                "      \"label\": \"Ya\",\n" +
                "      \"action\": \"next\",\n" +
                "      \"next_action\": {\n" +
                "        \"question\": \"Apakah ada ART yang berusia 0 (nol) Tahun atau bayi\",\n" +
                "        \"answer\": [{\n" +
                "          \"label\": \"Ya\",\n" +
                "          \"action\": \"skip\",\n" +
                "          \"message\": [\n" +
                "            \"(KOR Blok XIV R. 1402 - 1416 : Imunisasi) Imunisasi Lengkap BCG (4) Polio (4), DPT(3), HB (3), Campak(1)\",\n" +
                "            \"(KOR Blok XIV R. 1417 - 1419 : Kondisi ART 0 - 23 Tahun) Jenis Makanan Pendamping adakah sudah wajar dengan umur dan kondisi wilayah\",\n" +
                "            \"(KP Blok IV.2. R.239 - R.240 : Biaya Pelayanan Pengobatan) Minimal harus ada isian\",\n" +
                "            \"(KP Blok IV.2. R.250 : Biaya Periksa Kehamilan) Jika kosong, apakah benar\",\n" +
                "            \"(KP Blok IV.2 R.251: Biaya Imunisasi) Biaya imunisasi terisi\"\n" +
                "          ]\n" +
                "        },\n" +
                "          {\n" +
                "            \"label\": \"Tidak\",\n" +
                "            \"action\": \"skip\",\n" +
                "            \"message\": []\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      \"message\": []\n" +
                "    },\n" +
                "      {\n" +
                "        \"label\": \"Tidak\",\n" +
                "        \"action\": \"skip\",\n" +
                "        \"message\": []\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "    {\n" +
                "      \"question\": \"Apakah ada anak kandung (R.403 = 3)\",\n" +
                "      \"answer\": [{\n" +
                "        \"label\": \"Ya\",\n" +
                "        \"action\": \"skip\",\n" +
                "        \"message\": [\"Cek selisih umur anak (403 = 3) dengan umur orang tua di ruta ini harus > 12 Tahun\"]\n" +
                "      },\n" +
                "        {\n" +
                "          \"label\": \"Tidak\",\n" +
                "          \"action\": \"skip\",\n" +
                "          \"message\": []\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "\n" +
                "    {\n" +
                "      \"question\": \"Apakah ada yang status kawin/Cerai (R.404 > 1)\",\n" +
                "      \"answer\": [{\n" +
                "        \"label\": \"Ya\",\n" +
                "        \"action\": \"skip\",\n" +
                "        \"message\": [\n" +
                "          \"Cek Umur harus lebih dari 10 tahun\",\n" +
                "          \"Cek R.612 ≠ 2 pada jenjang ≤ SMA (R.613 < 15)\"\n" +
                "        ]\n" +
                "      },\n" +
                "        {\n" +
                "          \"label\": \"Tidak\",\n" +
                "          \"action\": \"skip\",\n" +
                "          \"message\": []\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ],\n" +
                "\n" +
                "  \"blokv\": [{\n" +
                "    \"question\": \"Apakah ada yang mempunyai NIK (R.502  terisi)?\",\n" +
                "    \"answer\": [{\n" +
                "      \"label\": \"Ya\",\n" +
                "      \"action\": \"next\",\n" +
                "      \"next_action\": {\n" +
                "        \"question\": \"Apakah ada yang sumber NIK dari KTP (R.503 = 2)\",\n" +
                "        \"answer\": [{\n" +
                "          \"label\": \"Ya\",\n" +
                "          \"action\": \"skip\",\n" +
                "          \"message\": [\"Cek umur di NIK (R.502 digit 7 - 12) dan B.IV R.407 lebih dari 17 tahun\"]\n" +
                "        },\n" +
                "          {\n" +
                "            \"label\": \"Tidak\",\n" +
                "            \"action\": \"skip\",\n" +
                "            \"message\": []\n" +
                "          }\n" +
                "        ]\n" +
                "      },\n" +
                "      \"message\": [\"Cek NIK digit 7 - 12 dengan tanggal dan tahun lahir (B.IV R.406)\"]\n" +
                "    },\n" +
                "      {\n" +
                "        \"label\": \"Tidak\",\n" +
                "        \"action\": \"skip\",\n" +
                "        \"message\": []\n" +
                "      }\n" +
                "    ]\n" +
                "  }],\n" +
                "\n" +
                "\n" +
                "  \"blokvi\": [{\n" +
                "    \"question\": \"Apakah R.606 ada yang terisi 1 atau 2\",\n" +
                "    \"answer\": [{\n" +
                "      \"label\": \"Ya\",\n" +
                "      \"action\": \"skip\",\n" +
                "      \"message\": [\"Cek umurnya 0 - 17 tahun, jika umur >17 maka kosong\"]\n" +
                "    },\n" +
                "      {\n" +
                "        \"label\": \"Tidak\",\n" +
                "        \"action\": \"skip\",\n" +
                "        \"message\": []\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "    {\n" +
                "      \"question\": \"Berapa kode yang terisi pada R.607?\",\n" +
                "      \"answer\": [{\n" +
                "        \"label\": \"1\",\n" +
                "        \"action\": \"skip\",\n" +
                "        \"message\": [\"Cek umur ART tersebut 0 -7 tahun, dan Blok KP B.IV.2. R.257 Iuran Sekolah Harus terisi\"]\n" +
                "      },\n" +
                "        {\n" +
                "          \"label\": \"2\",\n" +
                "          \"action\": \"skip\",\n" +
                "          \"message\": [\"Cek umur ART tersebut 0 -7 tahun, dan Blok KP B.IV.2. R.257 Iuran Sekolah Harus terisi,  R.608 terisi\"]\n" +
                "        },\n" +
                "        {\n" +
                "          \"label\": \"3\",\n" +
                "          \"action\": \"skip\",\n" +
                "          \"message\": [\"Cek umut ART tersebut umur 8 - 10 tahun,   R.608 terisi\"]\n" +
                "        },\n" +
                "        {\n" +
                "          \"label\": \"Lainnya\",\n" +
                "          \"action\": \"skip\",\n" +
                "          \"message\": []\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"question\": \"Apakah ada R. 609  = 5 tetapi R.610 / 611 = 1\",\n" +
                "      \"answer\": [{\n" +
                "        \"label\": \"Ya\",\n" +
                "        \"action\": \"skip\",\n" +
                "        \"message\": [\"cek ke petugas, apa benar bisa huruf arab/lainnya tetapi latin tidak bisa\"]\n" +
                "      },\n" +
                "        {\n" +
                "          \"label\": \"Tidak\",\n" +
                "          \"action\": \"skip\",\n" +
                "          \"message\": []\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"question\": \"Apakah ada R.612  = 2 masih bersekolah ?\",\n" +
                "      \"answer\": [{\n" +
                "        \"label\": \"Ya\",\n" +
                "        \"action\": \"skip\",\n" +
                "        \"message\": [\n" +
                "          \"Cek umur dengan kesesuaian jenjang (R. 613)\",\n" +
                "          \"Blok KP IV.2. R.255 - 260 harus terisi\",\n" +
                "          \"Jika R.613 < 15 maka R.404 > 2 (belum kawin/cerai)\"\n" +
                "        ]\n" +
                "      },\n" +
                "        {\n" +
                "          \"label\": \"Tidak\",\n" +
                "          \"action\": \"skip\",\n" +
                "          \"message\": []\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"question\": \"apakah ada R.613 = 2, 6, 10 (Sekolah Luar Biasa)?\",\n" +
                "      \"answer\": [{\n" +
                "        \"label\": \"Ya\",\n" +
                "        \"action\": \"skip\",\n" +
                "        \"message\": [\"Konfirmasi ke Petugas kejadian jarang (Rare Cases) apa benar ????\"]\n" +
                "      },\n" +
                "        {\n" +
                "          \"label\": \"Tidak\",\n" +
                "          \"action\": \"skip\",\n" +
                "          \"message\": []\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"question\": \"Apakah ada R.612 = 2 dan R.613 = 1, 5, 9 (pendidikan kejar paket)?\",\n" +
                "      \"answer\": [{\n" +
                "        \"label\": \"Ya\",\n" +
                "        \"action\": \"skip\",\n" +
                "        \"message\": [\"Konfirmasi ke PCL kejadian jarang, cek lokasi sampel apa memungkinkan\"]\n" +
                "      },\n" +
                "        {\n" +
                "          \"label\": \"Tidak\",\n" +
                "          \"action\": \"skip\",\n" +
                "          \"message\": []\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"question\": \"Apakah ada yang telah lulus (R614 = 8)\",\n" +
                "      \"answer\": [{\n" +
                "        \"label\": \"Ya\",\n" +
                "        \"action\": \"skip\",\n" +
                "        \"message\": [\"Cek keseuaian umur minimal lulus (SD min 10 thn, SMP min 13 tahun, SMA min 16 Thn\"]\n" +
                "      },\n" +
                "        {\n" +
                "          \"label\": \"Tidak\",\n" +
                "          \"action\": \"skip\",\n" +
                "          \"message\": []\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"question\": \"Apakah ada R.617 = 1\",\n" +
                "      \"answer\": [{\n" +
                "        \"label\": \"Ya\",\n" +
                "        \"action\": \"skip\",\n" +
                "        \"message\": [\n" +
                "          \"Cek R. 615 < 13\",\n" +
                "          \"Cek R. 2108 K. 2 dan K.3 terisi\"\n" +
                "        ]\n" +
                "      },\n" +
                "        {\n" +
                "          \"label\": \"Tidak\",\n" +
                "          \"action\": \"skip\",\n" +
                "          \"message\": []\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"question\": \"Apakah R.618 - R.620 terisi?\",\n" +
                "      \"answer\": [{\n" +
                "        \"label\": \"Ya\",\n" +
                "        \"action\": \"skip\",\n" +
                "        \"message\": [\"Cek R.612 harus terisi 2/ 3\"]\n" +
                "      },\n" +
                "        {\n" +
                "          \"label\": \"Tidak\",\n" +
                "          \"action\": \"skip\",\n" +
                "          \"message\": []\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ],\n" +
                "\n" +
                "\n" +
                "  \"blokvii\": [{\n" +
                "    \"question\": \"Apakah ada di R.701  kode X dilingkari\",\n" +
                "    \"answer\": [{\n" +
                "      \"label\": \"Ya\",\n" +
                "      \"action\": \"skip\",\n" +
                "      \"message\": [\n" +
                "        \"kode X dilingkari jika kode lainnya (A - D) tidak dilingkari\",\n" +
                "        \"Konfirmasi ke petugas, Kode X untuk ART yang tidak melakukan apa-apa seperti sakit, atau pemalas akut \"\n" +
                "      ]\n" +
                "    },\n" +
                "      {\n" +
                "        \"label\": \"Tidak\",\n" +
                "        \"action\": \"skip\",\n" +
                "        \"message\": []\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "    {\n" +
                "      \"question\": \"pada ART no. 1, apakah ada kode D tidak dilingkari?\",\n" +
                "      \"answer\": [{\n" +
                "        \"label\": \"Ya\",\n" +
                "        \"action\": \"skip\",\n" +
                "        \"message\": [\n" +
                "          \"Kegiatan pibadi tersebut meliputi kegiatan ARTdalam sosial kemasyarakatan, seperti rapat RT,  yasinan, melayat, kondangan dan lainnya\"\n" +
                "        ]\n" +
                "      },\n" +
                "        {\n" +
                "          \"label\": \"Tidak\",\n" +
                "          \"action\": \"skip\",\n" +
                "          \"message\": []\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"question\": \"Apakah ada ART bekerja / R.701 kode A dilingkari?\",\n" +
                "      \"answer\": [{\n" +
                "        \"label\": \"Ya\",\n" +
                "        \"action\": \"skip\",\n" +
                "        \"message\": [\n" +
                "          \"Cek isian 704 diisi petugas lengakap dan tulis lapangan usahanya\",\n" +
                "          \"Cek isian 705 - 707  terisi\"\n" +
                "        ]\n" +
                "      },\n" +
                "        {\n" +
                "          \"label\": \"Tidak\",\n" +
                "          \"action\": \"skip\",\n" +
                "          \"message\": []\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"question\": \"Apakah R.705 terisi 1 - 5\",\n" +
                "      \"answer\": [{\n" +
                "        \"label\": \"Ya\",\n" +
                "        \"action\": \"skip\",\n" +
                "        \"message\": [\n" +
                "          \"Cek isian KP Blok V.A Pendapatan upag/gaji atau V.B pendapatan usaha terisi\"\n" +
                "        ]\n" +
                "      },\n" +
                "        {\n" +
                "          \"label\": \"Tidak\",\n" +
                "          \"action\": \"skip\",\n" +
                "          \"message\": []\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ],\n" +
                "\n" +
                "  \"blokviii\": [{\n" +
                "    \"question\": \"Apakah ada R. 802 = 1  / menguasai HP ?\",\n" +
                "    \"answer\": [{\n" +
                "      \"label\": \"Ya\",\n" +
                "      \"action\": \"skip\",\n" +
                "      \"message\": [\n" +
                "        \"Blok KP - Cek isian Blok IV.2 R. 227 > 0 , biasanya ada pengeluaran untuk pulsa\"\n" +
                "      ]\n" +
                "    },\n" +
                "      {\n" +
                "        \"label\": \"Tidak\",\n" +
                "        \"action\": \"skip\",\n" +
                "        \"message\": []\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "    {\n" +
                "      \"question\": \"Apakah ada R.804 = 1 / menggunakan internet\",\n" +
                "      \"answer\": [{\n" +
                "        \"label\": \"Ya\",\n" +
                "        \"action\": \"skip\",\n" +
                "        \"message\": [\n" +
                "          \"Blok KP - Cek isian Blok IV.2 R. 229 > 0 , biasanya ada pengeluaran biaya internet\"\n" +
                "        ]\n" +
                "      },\n" +
                "        {\n" +
                "          \"label\": \"Tidak\",\n" +
                "          \"action\": \"skip\",\n" +
                "          \"message\": []\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"question\": \"Apakah ada R.807 kode B dilingkari\",\n" +
                "      \"answer\": [{\n" +
                "        \"label\": \"Ya\",\n" +
                "        \"action\": \"skip\",\n" +
                "        \"message\": [\n" +
                "          \"Cek ART nya masih/sedang bersekolah R.612 = 2\"\n" +
                "        ]\n" +
                "      },\n" +
                "        {\n" +
                "          \"label\": \"Tidak\",\n" +
                "          \"action\": \"skip\",\n" +
                "          \"message\": []\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"question\": \"Apakah ada  R.808 = 1\",\n" +
                "      \"answer\": [{\n" +
                "        \"label\": \"Ya\",\n" +
                "        \"action\": \"skip\",\n" +
                "        \"message\": [\n" +
                "          \"Blok KP Cek Blok IV.2. R.268 > 0 ada biaya jasa perbankan\"\n" +
                "        ]\n" +
                "      },\n" +
                "        {\n" +
                "          \"label\": \"Tidak\",\n" +
                "          \"action\": \"skip\",\n" +
                "          \"message\": []\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "\n" +
                "  ],\n" +
                "\n" +
                "  \"blokix\": [],\n" +
                "\n" +
                "  \"blokx\": [{\n" +
                "    \"question\": \"apakah ada ART dengan isian R. 1002 s.d. 1008 kode 1, 2, 5 atau 6 semua ?\",\n" +
                "    \"answer\": [{\n" +
                "      \"label\": \"Ya\",\n" +
                "      \"action\": \"skip\",\n" +
                "      \"message\": [\n" +
                "        \"Konfrmasi dengan petugas, bagaimana kondisi responden sebenarnya, apakah sesuai?\"\n" +
                "      ]\n" +
                "    },\n" +
                "      {\n" +
                "        \"label\": \"Tidak\",\n" +
                "        \"action\": \"skip\",\n" +
                "        \"message\": []\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "\n" +
                "  ]\n" +
                "\n" +
                "}"

        val gson = Gson()
        val datasets = gson.fromJson(jsonData!!,  Array<Question>::class.java) //Question::class.java)

        datasets.forEach {
//            println(it)
            listDatas.add(it)
        }

//        val parser = JsonParser()
//
//        try {
//            val res = resources
//            val in_s = res.openRawResource(R.raw.rule)
//
//            val b = ByteArray(in_s.available())
//            in_s.read(b)
//
//            val json_data = String(b)!!
//
//            val gson = Gson()
////            val datasetListType = object : TypeToken<Collection<Question>>() {}.type
//
//            val datasets = gson.fromJson(json_data!!, Question::class.java)
//
//        } catch (e: IOException) {
//        }


//        val jsonTree = parser.parse(json_data)
//        val jsonObject = jsonTree.asJsonObject

//        val blok_data = jsonObject.get("blokvi")


//        if(jsonTree.isJsonArray()){
//            listDatas.add(Question("answer": ))
//        }

//        val myModel = Gson().fromJson(myJson, MyModel::class.java)

//
        val heroesAdapter = QuestionAdapter(listDatas)

        rec_view.apply {
            layoutManager = LinearLayoutManager(this@BlokActivity)
            adapter = heroesAdapter
        }
    }

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
