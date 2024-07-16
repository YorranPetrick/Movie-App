package com.yorran.movieapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.yorran.movieapp.databinding.ActivityInfoFilmesBinding

class InfoFilmesActivity : AppCompatActivity() {

    lateinit var infoFilmesBinding: ActivityInfoFilmesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        infoFilmesBinding = ActivityInfoFilmesBinding.inflate(layoutInflater)
        setContentView(infoFilmesBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Criando variaveis para receber as informações passadas pelo putExtra

        val url_filme = intent.extras?.getString("url_filme")
        val nome = intent.extras?.getString("nome")
        val descricao = intent.extras?.getString("descricao")
        val elenco = intent.extras?.getString("elenco")


        Glide.with(this).load(url_filme).centerCrop().into(infoFilmesBinding.CapaFilme) //Usando o Glide para buscar e carregar a imageem dentro da ImageView
        infoFilmesBinding.NomeFilme.text = nome
        infoFilmesBinding.DescricaoFilme.text = descricao
        infoFilmesBinding.ElencoFilme.text = elenco

        infoFilmesBinding.backBtn.setOnClickListener {
            finish()
        }




    }
}