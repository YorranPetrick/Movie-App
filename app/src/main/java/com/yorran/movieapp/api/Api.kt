package com.yorran.movieapp.api

import com.yorran.movieapp.models.ListaCategorias
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("/filmes")
    fun listaCategorias() : Call<ListaCategorias>
}