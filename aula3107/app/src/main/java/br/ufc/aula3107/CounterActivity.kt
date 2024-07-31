package br.ufc.aula3107

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class CounterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)
        var contador = findViewById<TextView>(R.id.txtCount)
        var i = 1
        Thread(Runnable {
            while(i<=20){
                runOnUiThread{
                    contador.text = i.toString()
                }
                Thread.sleep(1000)
                i=i+1
            }

        }).start()
    }
}