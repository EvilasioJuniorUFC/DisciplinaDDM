package com.example.aula_17_04_2024

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity03)

        val btnShare: Button = findViewById(R.id.btnShareMessage)
        btnShare.setOnClickListener{
            val shareIntent = Intent()
            shareIntent.setAction(Intent.ACTION_SEND)
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Texto a ser compartilhado")
            shareIntent.setType("text/plain")
            startActivity(shareIntent)
        }


        val btnGoogle: Button = findViewById(R.id.btnUrl)
        btnGoogle.setOnClickListener{
            Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com")).also {
                startActivity(it)
            }

        }

        val btnYoutube:Button = findViewById(R.id.btnYoutube)
        btnYoutube.setOnClickListener{
            Intent(Intent.ACTION_MAIN).also{
                it.`package` = "com.google.android.youtube"
                startActivity(it)
            }
        }


    }
}