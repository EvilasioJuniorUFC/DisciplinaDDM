package com.example.aula_17_04_2024

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity02)

        val btnActivity01: Button = findViewById(R.id.btnActivity01)

        val lblNome:TextView = findViewById(R.id.lblNome)
        val lblMensagem:TextView = findViewById(R.id.lblMensagem)
        lblMensagem.setText(intent.getStringExtra("Name").toString())
        lblMensagem.setText(intent.getStringExtra("mensagem").toString())

        btnActivity01.setOnClickListener{
            val intentMessage = Intent(this, MainActivity::class.java)

            intentMessage.setAction(Intent.ACTION_SEND)
            intentMessage.putExtra(Intent.EXTRA_TEXT, "Olá, tudo bem?")
            intentMessage.setType("text/plain")
            startActivity(intentMessage)
        }
    }
}