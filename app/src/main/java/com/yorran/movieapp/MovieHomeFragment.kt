package com.yorran.movieapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.yorran.movieapp.Adapter.AdapterCategoria
import com.yorran.movieapp.api.Api
import com.yorran.movieapp.databinding.FragmentMovieHomeBinding
import com.yorran.movieapp.models.CategoriaFilmes
import com.yorran.movieapp.models.ListaCategorias
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


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
        fragmentMovieHomeBinding.recycleViewCategorias.layoutManager =
            LinearLayoutManager(requireContext())
        fragmentMovieHomeBinding.recycleViewCategorias.setHasFixedSize(true)

        // Criar e atribuir o adaptador ao RecyclerView
        adapterCategorias = AdapterCategoria(requireContext(), listaCategoria)
        fragmentMovieHomeBinding.recycleViewCategorias.adapter = adapterCategorias

        //Implementando o Retrofit
        val retroft = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://stackmobile.com.br/")
            .build()
            .create(Api::class.java)

        //Chamando o CallBack no Retrofit
        retroft.listaCategorias().enqueue(object : Callback<ListaCategorias>{
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<ListaCategorias>, response: Response<ListaCategorias>) {
                if(response.code() == 200){
                    response.body()?.let {
                        adapterCategorias.listaCategoria.addAll(it.nomeCategoria)
                        fragmentMovieHomeBinding.recycleViewCategorias.adapter = adapterCategorias
                        //Notificando a lista semppre que for atualizado
                        adapterCategorias.notifyDataSetChanged()

                    }
                }
            }

            override fun onFailure(call: Call<ListaCategorias>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })



        return fragmentMovieHomeBinding.root
    }


}

