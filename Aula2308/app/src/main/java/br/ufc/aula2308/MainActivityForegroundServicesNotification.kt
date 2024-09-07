package br.ufc.aula2308

import android.Manifest
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.ActivityCompat

class MainActivityForegroundServicesNotification : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_notification)

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.S){
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.POST_NOTIFICATIONS),
                0
            )
        }


        val btnStartNotification: Button = findViewById(R.id.btnStartNotification)
        val btnStopNotification: Button = findViewById(R.id.btnStopNotification)

        btnStartNotification.setOnClickListener{
            Intent(applicationContext, RunningService::class.java).also { intent->
                intent.action = RunningService.Actions.START.toString()
                startService(intent)
            }
        }

        btnStopNotification.setOnClickListener{
            Intent(applicationContext, RunningService::class.java).also { intent->
                intent.action = RunningService.Actions.STOP.toString()
                startService(intent)
            }
        }


    }
}