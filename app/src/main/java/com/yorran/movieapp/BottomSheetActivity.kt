package com.yorran.movieapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.yorran.movieapp.databinding.ActivityBottomSheetBinding

class BottomSheetActivity : AppCompatActivity() {

    private lateinit var buttomSheetBinding: ActivityBottomSheetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        buttomSheetBinding = ActivityBottomSheetBinding.inflate(layoutInflater)
        setContentView(buttomSheetBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        buttomSheetBinding.submitBtn.setOnClickListener {
            buttomSheetBinding.textInformationCPF.text = "Email Sent"
        }
    }
}