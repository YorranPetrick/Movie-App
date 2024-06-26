package com.yorran.movieapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.yorran.movieapp.databinding.ActivityNewAccountBinding

class NewAccountActivity : AppCompatActivity() {
    private lateinit var accountBinding: ActivityNewAccountBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        accountBinding = ActivityNewAccountBinding.inflate(layoutInflater)
        setContentView(accountBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        accountBinding.backBtn.setOnClickListener{
            finish()
        }

        accountBinding.nextBtn.setOnClickListener{
            startActivity(Intent(this, CreateAccountActivity::class.java))

        }
    }
}