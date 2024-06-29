package com.yorran.movieapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yorran.movieapp.databinding.CategoriaItemBinding
import com.yorran.movieapp.models.CategoriaFilmes

//Adapter das Categorias de filmes
//Parametro listaCategoria irá criar uma lista usando a class CategoriaFilmes
class AdapterCategoria(private val context : Context, private val listaCategoria: MutableList<CategoriaFilmes>):
    RecyclerView.Adapter<AdapterCategoria.CategoriaViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriaViewHolder {
        //Realizando o Inflate do Layout no metodo onCreate e criando os itens da lista
        val itemLista = CategoriaItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return CategoriaViewHolder(itemLista)
    }

    override fun onBindViewHolder(holder: CategoriaViewHolder, position: Int) {
        //Metodo responsável por visualizar os itens da lista
        // Pegará o titulo de cada categoria usando a posição
        holder.titulo.text = listaCategoria[position].titulo

    }

    override fun getItemCount() = listaCategoria.size
        //resposável por saber a quantidade de itens da lista




    inner class CategoriaViewHolder(biding : CategoriaItemBinding): RecyclerView.ViewHolder(biding.root){
        //Pegando os ID do Layout CategoriaItem com o Biding
        val titulo = biding.categoriaTitulo

    }
}