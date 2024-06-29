package com.yorran.movieapp.models


//Criando uma class onde irá conter as variaveis de dados para os filmes
data class CategoriaFilmes (
    val titulo : String ? = null,
    val listaFilmes : MutableList<ListaFilmes> = mutableListOf()
)

//Dados para a lista de Filmes
data class ListaFilmes(
    val capaFilmes: Int
)