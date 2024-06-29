package com.yorran.movieapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yorran.movieapp.databinding.CategoriaItemBinding
import com.yorran.movieapp.models.CategoriaFilmes
import com.yorran.movieapp.models.ListaFilmes

//Adapter das Categorias de filmes
//Parametro listaCategoria irá criar uma lista usando a class CategoriaFilmes
class AdapterCategoria(private val context : Context, private val listaCategoria: MutableList<CategoriaFilmes>, private val listafilmes : MutableList<ListaFilmes>):
    RecyclerView.Adapter<AdapterCategoria.CategoriaViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriaViewHolder {
        //Realizando o Inflate do Layout no metodo onCreate e criando os itens da lista
        val itemLista = CategoriaItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return CategoriaViewHolder(itemLista)
    }

    override fun onBindViewHolder(holder: CategoriaViewHolder, position: Int) {
        //Metodo responsável por visualizar os itens da lista
        // Pegará o titulo de cada categoria usando a posição
        val positionItem = listaCategoria[position]
        //Variavel que pegará a posição das informações que estão contidas no ListaCategoria
        holder.titulo.text = listaCategoria[position].titulo
        holder.filmes.adapter = AdapterFilmes(context, listafilmes)
        //Configuração da orientação
        holder.filmes.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

    }

    override fun getItemCount() = listaCategoria.size
        //resposável por saber a quantidade de itens da lista




    inner class CategoriaViewHolder(biding : CategoriaItemBinding): RecyclerView.ViewHolder(biding.root){
        //Pegando os ID do Layout CategoriaItem com o Biding
        val titulo = biding.categoriaTitulo
        val filmes = biding.recycleViewFilmes

    }
}