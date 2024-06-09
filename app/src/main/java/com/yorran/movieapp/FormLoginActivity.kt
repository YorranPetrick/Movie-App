package com.yorran.movieapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.yorran.movieapp.databinding.ActivityFormLoginBinding

class FormLoginActivity : AppCompatActivity() {

    private lateinit var formBiding : ActivityFormLoginBinding
    private lateinit var googleSignInClient : GoogleSignInClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        formBiding = ActivityFormLoginBinding.inflate(layoutInflater)
        setContentView(formBiding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        formBiding.backBtn.setOnClickListener{
           finish()
        }

        formBiding.forgotPassword.setOnClickListener{
            val dialog = BottomSheetDialog(this)
            val view=layoutInflater.inflate(R.layout.activity_bottom_sheet, null)
            dialog.setContentView(view)
            dialog.show()
        }

    }
}