package com.example.aula_05_04_2024

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class FibonacciActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fibonacci)

        val edtFib: EditText = findViewById(R.id.edtFib)
        val btnFib: Button = findViewById(R.id.btnFib)
        val lblResultFib: TextView = findViewById(R.id.lblResultFib)

        btnFib.setOnClickListener{
            lblResultFib.setText(fibonacci(edtFib.text.toString().toInt()).toString())
        }

    }

    fun fibonacci(pos:Int):Long{
        var valueFib:Long = 1
        var valueFibAnt:Long = 1

        for (i in 3..pos){
            val valueAux =  valueFib
            valueFib = valueFib+valueFibAnt
            valueFibAnt = valueAux
        }

        return valueFib
    }
}