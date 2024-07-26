package br.ufc.aula2607

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.CountDownTimer
import android.os.IBinder
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationBuilderWithBuilderAccessor
import androidx.core.content.getSystemService

class ServicoTest: Service()  {
    var threads = ArrayList<Worker>();

    //var active = true
    override fun onBind(intent: Intent?): IBinder? {
        return null // Para um Started Service
    }

    override fun onCreate() {
        super.onCreate()
        Log.i("Script", "onCreate")
    }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // Código para executar em segundo plano
        Log.i("Script", "onStartCommand")
        var w = Worker(startId)
        w.start()
        threads.add(w)
        var count = 0

        return START_STICKY // START_NOT_STICKY // Para reiniciar o service se o sistema o matar
    }

    override fun onDestroy() {
        super.onDestroy()
        //active = false
        for(i in threads){
            i.active = false
        }

        // Limpeza de recursos
    }

    class Worker(var startId:Int): Thread(){
        var count = 0
        var active: Boolean = true

        override fun run(){
            while (active && count < 10){
                Thread.sleep(1000)
                count += 1
                Log.i("Script", "Count: " + count)
            }
            Log.i("Script", "FinalCount: " + count)
            this.interrupt()

        }
    }

}