package br.ufc.aula16_08

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.material3.Snackbar
import br.ufc.aula16_08.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException

class MainActivity : AppCompatActivity() {

    private val auth = FirebaseAuth.getInstance()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCadastrar.setOnClickListener { view ->
            val email = binding.edtLogin.text.toString()
            val senha = binding.edtSenha.text.toString()

            if (email.isNullOrEmpty() ||
                senha.isNullOrEmpty()
            ) {
                val snackbar = Snackbar.make(view,"Preencha Todos os Campos", Snackbar.LENGTH_SHORT)
                snackbar.setBackgroundTint(Color.RED)
                snackbar.show()
            } else {
                auth.createUserWithEmailAndPassword(email,senha).addOnCompleteListener{cadastro->
                    if (cadastro.isSuccessful){
                        val snackbar = Snackbar.make(view,"O cadastro foi um sucesso", Snackbar.LENGTH_SHORT)
                        snackbar.setBackgroundTint(Color.GREEN)
                        snackbar.show()
                        binding.edtLogin.setText("")
                        binding.edtSenha.setText("")
                    }
                }.addOnFailureListener{exception->
                    val mensagemErro = "Erro de cadastro"
                    /*val mensagemErro = when(exception){
                        is FirebaseAuthWeakPasswordException -> "Digite uma senha com pelo menos 6 dígitos"
                        is FirebaseAuthInvalidCredentialsException -> "Digite um email válido"
                        is FirebaseAuthUserCollisionException -> "Usuário já cadastrado"
                        is FirebaseNetworkException -> "Sem conexão com a Internet!"
                        else -> "Erro ao cadastra o usuário!"
                    }*/
                    val snackbar = Snackbar.make(view,mensagemErro, Snackbar.LENGTH_SHORT)
                    snackbar.setBackgroundTint(Color.RED)
                    snackbar.show()


                }
            }
        }

    }
}