package com.yorran.movieapp.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yorran.movieapp.InfoFilmesActivity
import com.yorran.movieapp.databinding.FilmesItemBinding
import com.yorran.movieapp.models.ListaFilmes

class AdapterFilmes (private val context: Context, private val listaFilmes: MutableList<ListaFilmes>):
    RecyclerView.Adapter<AdapterFilmes.FilmesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmesViewHolder {
        val itemLista = FilmesItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return FilmesViewHolder(itemLista)
    }

    override fun onBindViewHolder(holder: FilmesViewHolder, position: Int) {
        Glide.with(context).load(listaFilmes[position].capaFilmes).centerCrop().into(holder.capa)

        //Criando o envento de clique e passando dados de uma Activity para outra com o PutExtra
        holder.capa.setOnClickListener {
            val intent = Intent(context, InfoFilmesActivity::class.java)
            intent.putExtra("url_filme", listaFilmes[position].capaFilmes)
            intent.putExtra("nome", listaFilmes[position].nome)
            intent.putExtra("descricao", listaFilmes[position].descricao)
            intent.putExtra("elenco", listaFilmes[position].elenco)

            context.startActivity(intent)
        }

    }

    override fun getItemCount() = listaFilmes.size


    inner class FilmesViewHolder(biding : FilmesItemBinding): RecyclerView.ViewHolder(biding.root) {
        val capa = biding.capaFilme

    }
}