package br.ufc.aula16_08

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.ufc.aula16_08.databinding.ActivityLoginBinding
import br.ufc.aula16_08.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException

class LoginActivity : AppCompatActivity() {
    private val auth = FirebaseAuth.getInstance()
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.txtTelaCadastro.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        binding.btnLogin.setOnClickListener { view ->
            val email = binding.edtLogin.text.toString()
            val senha = binding.edtSenha.text.toString()

            if (email.isNullOrEmpty() ||
                senha.isNullOrEmpty()
            ) {
                val snackbar = Snackbar.make(view,"Preencha Todos os Campos", Snackbar.LENGTH_SHORT)
                snackbar.setBackgroundTint(Color.RED)
                snackbar.show()
            } else {
                auth.signInWithEmailAndPassword(email,senha).addOnCompleteListener{autenicacao->
                    if(autenicacao.isSuccessful){
                        val intent = Intent(this,RealMainActivity::class.java)
                        startActivity(intent)
                    }
                }.addOnFailureListener{exception->
                    val snackbar = Snackbar.make(view,"Email ou Senha Inválidos", Snackbar.LENGTH_SHORT)
                    snackbar.setBackgroundTint(Color.RED)
                    snackbar.show()
                }
            }
        }
    }

    private fun navegarTelaPrincipal(){
        val intent = Intent(this,RealMainActivity::class.java)
        startActivity(intent)
    }
    override fun onStart() {
        super.onStart()

        val usuarioAtual = FirebaseAuth.getInstance().currentUser
        if (usuarioAtual != null)
            navegarTelaPrincipal()
    }
}