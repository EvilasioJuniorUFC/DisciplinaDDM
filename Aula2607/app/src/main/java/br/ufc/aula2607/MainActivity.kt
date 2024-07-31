package br.ufc.aula2607

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.GregorianCalendar

const val CHANNEL_ID = "channelid"

class MainActivity : AppCompatActivity() {
    companion object{
        var context:Context? =null
        fun mostraToast(num:Int){
                    Toast.makeText(context, "Count: " + num, Toast.LENGTH_SHORT).show()
        }
    }
lateinit var horario:TextView;
        @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            context = applicationContext
            horario = findViewById(R.id.textView)
            horario.text = UtilData.informaHoraAtual()

        }
    @RequiresApi(Build.VERSION_CODES.O)
    fun startService(view: View){
        val intent = Intent(this, ServicoTest::class.java)
        intent.putExtra("horario", horario.text)
        startForegroundService(intent)
    }
    fun stopService(view: View){
        val intent =  Intent(this, ServicoTest::class.java)
        stopService(intent)
    }




}