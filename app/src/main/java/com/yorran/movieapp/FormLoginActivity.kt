package com.yorran.movieapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.firebase.auth.FirebaseAuth
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

        formBiding.btnLogin.setOnClickListener {
            val email : String = formBiding.textFieldEmail.text.toString()
            val password : String = formBiding.textFieldSenha.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()){
                // Metodo para realizar o login
                clearFromError()
                login(email, password)

            }
            else{
                when{
                    email.isEmpty() -> formBiding.textFieldEmailLayout.helperText = "Email não pode ser Vazio"
                    password.isEmpty() -> formBiding.textFieldSenhaLayout.helperText = "Senha não pode ser Vazia"
                }
            }
        }

    }

    private fun login(email : String, password : String){
        //Instancia do Firebase para fazer o login com email e senha
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener(){auth->
            if (auth.isSuccessful){

                //Activity da tela de filmes
                startActivity(Intent(this, MovieMainActivity::class.java))
                finish()

            }
        }.addOnFailureListener {

        }


    }

    private fun clearFromError(){
        formBiding.textFieldEmailLayout.helperText = ""
        formBiding.textFieldSenhaLayout.helperText = ""
    }

     /*override fun onStart() {
        super.onStart()
        //Verificando se um usuário está autenticaado com o currentUser
        val user = FirebaseAuth.getInstance().currentUser
        //Toast.makeText(this, "$user", Toast.LENGTH_LONG).show()


        if (user != null) {
            startActivity(Intent(this, MovieMainActivity::class.java))
            finish()
        }
    }*/
}