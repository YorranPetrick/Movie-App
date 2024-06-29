package com.yorran.movieapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yorran.movieapp.databinding.FilmesItemBinding
import com.yorran.movieapp.models.ListaFilmes

class AdapterFilmes (private val context: Context, private val listaFilmes: MutableList<ListaFilmes>):
    RecyclerView.Adapter<AdapterFilmes.FilmesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmesViewHolder {
        val itemLista = FilmesItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return FilmesViewHolder(itemLista)
    }

    override fun onBindViewHolder(holder: FilmesViewHolder, position: Int) {
        holder.capa.setImageResource(listaFilmes[position].capaFilmes!!)

    }

    override fun getItemCount() = listaFilmes.size


    inner class FilmesViewHolder(biding : FilmesItemBinding): RecyclerView.ViewHolder(biding.root) {
        val capa = biding.capaFilme

    }
}