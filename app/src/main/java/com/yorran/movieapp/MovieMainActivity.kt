package com.yorran.movieapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.yorran.movieapp.databinding.ActivityMovieMainBinding

class MovieMainActivity : AppCompatActivity() {

    lateinit var movieMainBinding: ActivityMovieMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieMainBinding = ActivityMovieMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(movieMainBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        replaceFragment(MovieHomeFragment())

        movieMainBinding.bottomNavigation.setOnItemSelectedListener {menuItem ->
            when(menuItem.itemId){
                R.id.home_icon -> {
                    replaceFragment(MovieHomeFragment())
                    true
                }
                R.id.person_icon ->{
                    replaceFragment(InfoAccountFragment())
                    true
                }
                R.id.back_icon -> {
                    logOutUser()
                   true
                }
                else -> false
            }

        }
    }

    private fun replaceFragment(fragment: Fragment){
        //Pegando o parametro fragment do metodo e colocandoo em exibição
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container_view, fragment).commit()
    }

    private fun logOutUser(){
        //Log Out do usuário do firebase
        FirebaseAuth.getInstance().signOut()
        startActivity(Intent(this, MainActivity::class.java))
        finish()

        Toast.makeText(this, "Usuário Sig Out", Toast.LENGTH_SHORT).show()
    }
}