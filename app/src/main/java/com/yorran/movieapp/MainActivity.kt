package com.yorran.movieapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.yorran.movieapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBiding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mainBiding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBiding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        mainBiding.loginBtn.setOnClickListener{
            Toast.makeText(this, "BTN clicado", Toast.LENGTH_LONG).show()
        }

        mainBiding.nwwAccontBtn.setOnClickListener{
            startActivity(Intent(this, NewAccountActivity::class.java))
            Toast.makeText(this, "BTN clicado", Toast.LENGTH_LONG).show()
        }
    }
}