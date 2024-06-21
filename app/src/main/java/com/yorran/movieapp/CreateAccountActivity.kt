package com.yorran.movieapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthEmailException
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.yorran.movieapp.databinding.ActivityCreateAccountBinding

class CreateAccountActivity : AppCompatActivity() {

    lateinit var createAccountBinding: ActivityCreateAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        createAccountBinding = ActivityCreateAccountBinding.inflate(layoutInflater)
        setContentView(createAccountBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        createAccountBinding.btnRegister.setOnClickListener {
            val email = createAccountBinding.textFieldEmail.text.toString()
            val senha = createAccountBinding.textFieldPassoword.text.toString()
            val nome = createAccountBinding.textFieldFullName.text.toString()
            val cpf = createAccountBinding.textFieldCpf.text.toString()

            if (email.isNotEmpty() && senha.isNotEmpty() && nome.isNotEmpty() && cpf.isNotEmpty()) {
                // Todos os campos estão preenchidos corretamente
                clearFieldErrors()
                registration(email, senha)
            } else {
                // Exibir mensagens de erro específicas
                showFieldErrors(nome, email, senha, cpf)
            }
        }
    }

    private fun clearFieldErrors() {
        createAccountBinding.textFieldCpfLayout.helperText = ""
        createAccountBinding.textFieldFullNameLayout.helperText = ""
        createAccountBinding.textFieldPassowordLayout.helperText = ""
        createAccountBinding.textFildEmailLayout.helperText = ""
    }

    private fun showFieldErrors(nome: String, email: String, senha: String, cpf: String) {
        if (nome.isEmpty()) {
            createAccountBinding.textFieldFullNameLayout.helperText = "O campo de nome é obrigatório"
        }
        if (email.isEmpty()) {
            createAccountBinding.textFildEmailLayout.helperText = "O campo de email é obrigatório"
        }
        if (senha.isEmpty()) {
            createAccountBinding.textFieldPassowordLayout.helperText = "O campo de senha é obrigatório"
        }
        if (cpf.isEmpty()) {
            createAccountBinding.textFieldCpfLayout.helperText = "O campo de CPF é obrigatório"
        }
    }

    private fun registration(email:String, senha: String){
        //Recuperando a instancia do Firebase e criando um usuario com o email e senha
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(
            email,
            senha
        ).addOnCompleteListener { register ->
            if (register.isSuccessful){
                Toast.makeText(this, "Cadastrado com Sucesso", Toast.LENGTH_SHORT).show()
            }

        }.addOnFailureListener{excepion->
            //Verificando se a senha tem menos de 8 digitos
            if (excepion is FirebaseAuthWeakPasswordException){
                createAccountBinding.textFieldPassowordLayout.helperText = "Erro ao criar conta, Senha Fraca"
            }
            if (excepion is FirebaseAuthEmailException){
                createAccountBinding.textFieldFullNameLayout.helperText = "Erro ao criar conta, Email invalido"
            }
            if (excepion is FirebaseAuthUserCollisionException){
                createAccountBinding.textFildEmailLayout.helperText = "Erro ao criar conta, Email já está vinculado ao Banco de Daos"
            }

        }
    }
}
