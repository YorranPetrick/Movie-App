package com.yorran.movieapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.yorran.movieapp.Adapter.AdapterCategoria
import com.yorran.movieapp.databinding.FragmentMovieHomeBinding
import com.yorran.movieapp.models.CategoriaFilmes


class MovieHomeFragment : Fragment() {
    private lateinit var fragmentMovieHomeBinding: FragmentMovieHomeBinding
    private lateinit var adapterCategorias: AdapterCategoria
    private var listaCategoria: MutableList<CategoriaFilmes> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentMovieHomeBinding = FragmentMovieHomeBinding.inflate(inflater, container, false)

        // Configurar o LinearLayoutManager para o RecyclerView
        fragmentMovieHomeBinding.recycleViewCategorias.layoutManager = LinearLayoutManager(requireContext())
        fragmentMovieHomeBinding.recycleViewCategorias.setHasFixedSize(true)
        getCategorias()

        // Criar e atribuir o adaptador ao RecyclerView
        adapterCategorias = AdapterCategoria(requireContext(), listaCategoria)
        fragmentMovieHomeBinding.recycleViewCategorias.adapter = adapterCategorias

        return fragmentMovieHomeBinding.root
    }

    //Populando as Categorias
    private fun getCategorias(){
        val primeiraCategoria = CategoriaFilmes("Filmes Populares")
        val segundaCategoria = CategoriaFilmes("Filmes de Ação")
        val terceiraCategoria = CategoriaFilmes("Animações")
        listaCategoria.add(primeiraCategoria)
        listaCategoria.add(segundaCategoria)
        listaCategoria.add(terceiraCategoria)
    }
}