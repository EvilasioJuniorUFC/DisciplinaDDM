package br.ufc.aula16_08

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.ufc.aula16_08.databinding.*
import br.ufc.aula16_08.databinding.ActivityRealMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage

class RealMainActivity : AppCompatActivity() {

    lateinit var binding: ActivityRealMainBinding
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_real_main)

        binding = ActivityRealMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var idLastlivro = intent.getStringExtra("idLastLivro")

        if(idLastlivro == null){
            idLastlivro = "Sapiens"
        }

        binding.btnDeslogar.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnCadastrarLivro.setOnClickListener{
            val intent = Intent(this, CadastroLivroActivity::class.java)
            startActivity(intent)
        }

        binding.btnVerLivro.setOnClickListener{
            if(idLastlivro != null){
                val intent = Intent(this, LivroActivity::class.java)
                intent.putExtra("id", idLastlivro)
                startActivity(intent)
            }else
                Toast.makeText(this,"Não há Livros Cadastrados",Toast.LENGTH_SHORT).show()

        }

    }
}