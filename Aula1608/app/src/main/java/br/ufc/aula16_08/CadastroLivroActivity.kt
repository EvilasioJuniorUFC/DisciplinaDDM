package br.ufc.aula16_08

import android.content.ContentValues
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import br.ufc.aula16_08.databinding.ActivityCadastroLivroBinding
import br.ufc.aula16_08.databinding.ActivityLivroBinding
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore
import com.google.firebase.Firebase
import com.google.firebase.storage.FirebaseStorage

class CadastroLivroActivity : AppCompatActivity() {
    val db = Firebase.firestore
    private val storage = FirebaseStorage.getInstance()

    private var uriImagem: Uri? = null

    lateinit var binding: ActivityCadastroLivroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroLivroBinding.inflate(layoutInflater)

        setContentView(binding.root)

        /*
        val pickImage = registerForActivityResult(ActivityResultContracts.GetContent()){
            binding.imgCapa.setImageURI(it)
            if (it != null){
                uriImagem = it
            }
        }*/

        binding.imgCapa.setOnClickListener{
            //pickImage.launch("image/*")
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            val contentValues = ContentValues()
            contentValues.put(MediaStore.MediaColumns.MIME_TYPE,"image/jpeg")
            val resolver =  contentResolver
            uriImagem = resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,contentValues)
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
            intent.putExtra(MediaStore.EXTRA_OUTPUT,uriImagem)
            startActivityForResult(intent,22)

        }


        binding.btnCadastrar.setOnClickListener{

            val titulo = binding.edtTitulo.text.toString()
            val autor = binding.edtAutor.text.toString()
            val anoPublicacao = binding.edtAnoPublicacao.text.toString()
            val resumo = binding.edtResumo.text.toString()


            //Envia imagem para o storage e dados para o firestore
            //Images será o nome da pasta no storage onde ficará as imagens
            var storageReference =  storage.getReference("Images")
            uriImagem?.let { imagem->
                storageReference.child(titulo).putFile(imagem).addOnSuccessListener{task->
                    task.metadata!!.reference!!.downloadUrl.addOnSuccessListener {url->
                        val imagemUri = url.toString()
                        Log.i("storage","operação realizada com sucesso")

                        var hashmap = hashMapOf<String?,Any>()
                        hashmap.put("titulo", titulo)
                        hashmap.put("autor", autor)
                        hashmap.put("anoPublicacao", anoPublicacao)
                        hashmap.put("resumo", resumo)
                        hashmap.put("imagemUri", imagemUri)

                        var dbreference = db.collection("Livros")
                        dbreference.document(titulo)
                            .set(hashmap).addOnSuccessListener {

                                val intent = Intent(this, RealMainActivity::class.java)
                                intent.putExtra("idLastLivro",titulo)
                                startActivity(intent)
                            }.addOnFailureListener{
                                Toast.makeText(this, "Erro", Toast.LENGTH_LONG).show()
                            }
                    }

                }.addOnFailureListener{exception->
                    Toast.makeText(this, "ocorreu um erro ao enviar a imagem", Toast.LENGTH_SHORT).show()
                }
            }


        }



    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        binding.imgCapa.setImageURI(uriImagem)
    }
}