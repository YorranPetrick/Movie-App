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
import com.yorran.movieapp.models.ListaFilmes


class MovieHomeFragment : Fragment() {
    private lateinit var fragmentMovieHomeBinding: FragmentMovieHomeBinding
    private lateinit var adapterCategorias: AdapterCategoria
    private var listaCategoria: MutableList<CategoriaFilmes> = mutableListOf()
    //variavel para testar a lista de filmes
    private var filmesLista : MutableList<ListaFilmes> = mutableListOf()

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
        getFilmes()

        // Criar e atribuir o adaptador ao RecyclerView
        adapterCategorias = AdapterCategoria(requireContext(), listaCategoria, filmesLista)
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

    private fun getFilmes(){
        val primeiroFilme = ListaFilmes(R.drawable.ic_launcher_background)
        val segundoFilme = ListaFilmes(R.drawable.ic_launcher_background)
        val terceiroFilme = ListaFilmes(R.drawable.ic_launcher_background)
        val quartoFilme = ListaFilmes(R.drawable.ic_launcher_background)

        filmesLista.add(primeiroFilme)
        filmesLista.add(segundoFilme)
        filmesLista.add(terceiroFilme)
        filmesLista.add(quartoFilme)

    }
}