package br.ufc.aula2607

import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.GregorianCalendar

const val CHANNEL_ID = "channelid"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intentFilter = IntentFilter()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun startService(view: View){
        val intent = Intent(this, ServicoTest::class.java)
        startForegroundService(intent)
    }
    fun stopService(view: View){
        val intent =  Intent(this, ServicoTest::class.java)
        stopService(intent)
    }

    companion object{

        val sdf = SimpleDateFormat("HH:mm:ss")
        @RequiresApi(Build.VERSION_CODES.O)
        val dtf = DateTimeFormatter.ofPattern("HH:mm:ss")
        fun informaDiferecaMinutos(horario:String):String{//horario format "HH:mm:ss"
                return (sdf.format(Date()).substring(3,5).toInt() - horario.substring(3,5).toInt()).toString()
        }
    }

}