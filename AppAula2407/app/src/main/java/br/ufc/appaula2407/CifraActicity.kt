package br.ufc.appaula2407

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity

class CifraActicity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cifra_acticity)

        var txt = findViewById<TextView>(R.id.textView2)
        var btn = findViewById<Button>(R.id.button2)
        txt.text = intent.getStringExtra("cifra")
        btn.setOnClickListener(){
            var voltar = Intent(this,MainActivity::class.java)
            startActivity(voltar)

        }

    }
}