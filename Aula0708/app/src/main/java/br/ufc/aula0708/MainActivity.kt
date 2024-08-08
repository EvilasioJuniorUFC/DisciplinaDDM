package br.ufc.aula0708

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import br.ufc.aula0708.developer.Developer


class MainActivity : AppCompatActivity() {

    lateinit var edtNome: EditText
    lateinit var edtLinguagem: EditText
    lateinit var edtIdade: EditText
    lateinit var edtURLFoto: EditText
    lateinit var edtBiografia: EditText
    lateinit var btnVerPerfil: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtNome = findViewById(R.id.edtNome)
        edtLinguagem = findViewById(R.id.edtLinguagem)
        edtIdade = findViewById(R.id.edtIdade)
        edtURLFoto = findViewById(R.id.edtUrlFoto)
        edtBiografia = findViewById(R.id.edtBiografia)
        btnVerPerfil = findViewById(R.id.btnVerPerfil)

    }

    private fun camposValidos():Boolean{
        return(!edtNome.text.isNullOrEmpty() ||
                edtLinguagem.text.isNullOrEmpty() ||
                edtIdade.text.isNullOrEmpty() ||
                edtURLFoto.text.isNullOrEmpty())
    }

    fun verPerfil(v:View) {
        if (camposValidos()) {
            val nome = edtNome.text.toString()
            val linguagem = edtLinguagem.text.toString()
            val idade = edtIdade.text.toString().toInt()
            val foto = edtURLFoto.text.toString()
            val biografia = edtBiografia.text.toString()
            val developer = Developer(nome, linguagem, idade, foto, biografia)
            val intent = Intent(this, PerfilActivity::class.java)
            intent.putExtra("developer", developer)
            startActivity(intent)
        } else {
            // Mostra uma mensagem de erro
            Toast.makeText(
                applicationContext,
                getString(R.string.campos_incorrectos),
                Toast.LENGTH_SHORT
            ).show()

        }
    }

}