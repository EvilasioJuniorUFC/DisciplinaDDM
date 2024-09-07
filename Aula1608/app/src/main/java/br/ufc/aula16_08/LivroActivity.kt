package br.ufc.aula16_08

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.ufc.aula16_08.databinding.ActivityLivroBinding
import br.ufc.aula16_08.databinding.ActivityLoginBinding
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class LivroActivity : AppCompatActivity() {
    private val db = FirebaseFirestore.getInstance()
    lateinit var binding: ActivityLivroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLivroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //resgata id do último livro
        val idColecao = intent.getStringExtra("id")
        //preenche informações do livro

        binding.btnVoltar.setOnClickListener{
            val intent = Intent(this, RealMainActivity::class.java)
            startActivity(intent)
        }

        db.collection("Livros").document(idColecao!!)
            .addSnapshotListener{ documento, error ->
                if(documento != null){
                    binding.txtTitulo.text = documento.getString("titulo")
                    binding.txtAutor.text = documento.getString("autor")
                    binding.txtAno.text = documento.getString("anoPublicacao")
                    binding.txtResumo.text = documento.getString("resumo")
                    val urlimage = documento.getString("imagemUri")

                    Glide.with(this)
                        .load(urlimage)
                        .placeholder(R.drawable.ic_launcher_foreground)
                        .into(binding.imgFotoDeCapa)

                }
            }

        //update
        //delete

    }

}