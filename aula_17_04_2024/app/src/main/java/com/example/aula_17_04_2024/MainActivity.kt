package com.example.aula_17_04_2024

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import java.net.URI


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity01)

        val btnActivity02: Button = findViewById(R.id.btnActivity2)
        val btnActivity03: Button = findViewById(R.id.btnActivity3)
        btnActivity02.setOnClickListener{
            val intent01 = Intent(this, SecondActivity::class.java)

            intent01.putExtra("Name","Evilasio")
            intent01.putExtra("mensagem","Olá")
            startActivity(intent01)
        }
        btnActivity03.setOnClickListener{
            val intent02 = Intent(this, ThirdActivity::class.java)
            startActivity(intent02)
        }
    }

}
