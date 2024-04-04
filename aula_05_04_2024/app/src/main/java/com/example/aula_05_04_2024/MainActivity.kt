package com.example.aula_05_04_2024

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.aula_05_04_2024.ui.theme.Aula_05_04_2024Theme
import java.math.RoundingMode

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.imc_main)

        var lblResult: TextView = findViewById(R.id.lblResult)
        var edtAltura: EditText = findViewById(R.id.edtAltura)
        var edtPeso: EditText = findViewById(R.id.edtPeso)
        var btnCalcIMC: Button = findViewById(R.id.btnCalcIMC)

        btnCalcIMC.setOnClickListener{
            val result =    edtPeso.text.toString().toDouble()/(
                            edtAltura.text.toString().toDouble() *
                            edtAltura.text.toString().toDouble())
            lblResult.text = result.toBigDecimal().setScale(2, RoundingMode.UP).toDouble().toString()
        }


    }
}