package br.ufc.aula0708

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import br.ufc.aula0708.developer.Developer
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView
import java.net.URL

class PerfilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        // 1. Declara e inicializa a variavel developer que recebe o EXTRA passado pela activity anterior
        val developer = intent.getSerializableExtra("developer") as Developer
        // 2. Declara e inicializa as variaveis que fazerem referencias  aos elementos do layout
        val txtNome = findViewById<TextView>(R.id.txtNome)
        val txtIdade = findViewById<TextView>(R.id.txtIdade)
        val txtLinguagem = findViewById<TextView>(R.id.txtLinguagem)
        val txtBiografia = findViewById<TextView>(R.id.txtBiografia)
        val imgFotoDeCapa = findViewById<ImageView>(R.id.imgFotoDeCapa)
        val imgFotoDePerfil = findViewById<CircleImageView>(R.id.imgFotoDePerfil)

        var url = URL("https://yopinando.wordpress.com/wp-content/uploads/2024/07/os-complexos-esquemas-e-aliancas-na-estreia-do-shogun-explicados.jpg")

        // Biblioteca Glide, coloca a imagem do URL na ImageView foto de capa
        Glide.with(this)
            .load(developer.foto) // URL da imagem
            .placeholder(R.drawable.ic_launcher_background) // Caso o URL da imagem nao seja valido
            .into(imgFotoDeCapa) // ImageView que recebe a imagem do url
        // Biblioteca Glide, coloca a imagem do URL na ImageView foto de capa
        Glide.with(this)
            .load(developer.foto) // URL da imagem
            .placeholder(R.drawable.ic_launcher_background)
            .into(imgFotoDePerfil) // Caso o URL da imagem nao seja valido

        txtNome.text = developer.name
        txtIdade.text = developer.idade.toString()
        txtLinguagem.text = developer.linguagem
        txtBiografia.text = developer.biografia

    }
}