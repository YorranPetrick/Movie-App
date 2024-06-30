package com.yorran.movieapp.models

import com.google.gson.annotations.SerializedName


//Criando uma class onde irá conter as variaveis de dados para os filmes
data class CategoriaFilmes (

    @SerializedName("titulo") val titulo : String ? = null,
    @SerializedName("capas") val listaFilmes : MutableList<ListaFilmes> = mutableListOf()
)

//Dados para a lista de Filmes
data class ListaFilmes(
    @SerializedName("id") val id :Int = 0,
    @SerializedName("url_imagem") val capaFilmes: String? = null,

)

data class ListaCategorias(
    @SerializedName("categoria") val nomeCategoria : MutableList<CategoriaFilmes> = mutableListOf()
)