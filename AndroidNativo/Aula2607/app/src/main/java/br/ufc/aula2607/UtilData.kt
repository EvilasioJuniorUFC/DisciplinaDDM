package br.ufc.aula2607

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.Date

class UtilData {
    companion object{

        val sdf = SimpleDateFormat("HH:mm:ss")
        @RequiresApi(Build.VERSION_CODES.O)
        val dtf = DateTimeFormatter.ofPattern("HH:mm:ss")
        fun informaDiferecaMinutos(horario:String):String{//horario format "HH:mm:ss"
            return (sdf.format(Date()).substring(3,5).toInt() - horario.substring(3,5).toInt()).toString()
        }

        fun informaHoraAtual():String{
            return sdf.format(Date())
        }
    }
}