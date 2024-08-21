package br.ufc.notificationsample

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat


class MainActivity : AppCompatActivity() {

    //lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        val btnNotificar : Button = findViewById(R.id.btnNotificar)
        NotificationUtil.createChannel(this)
        btnNotificar.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            NotificationUtil.create(this, 1, intent, "Hello", "Hello World!")
        }

    }

    object NotificationUtil {
        internal val ID_CHANNEL = "1"

        fun createChannel(context: Context){
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O){
                val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                val appName =  context.getString(R.string.app_name)
                val c = NotificationChannel(ID_CHANNEL, appName, NotificationManager.IMPORTANCE_DEFAULT)
                c.lightColor = Color.BLUE
                c.lockscreenVisibility - Notification.VISIBILITY_PRIVATE
                manager.createNotificationChannel(c)
            }
        }

        fun create(context: Context, id:Int, intent:Intent, title:String, msg:String){
            val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val p = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_MUTABLE)
            val builder = NotificationCompat.Builder(context,"id")
                .setContentIntent(p).setContentTitle(title).setContentText(msg)
                .setSmallIcon(R.mipmap.ic_launcher).setAutoCancel(true)
            val n = builder.build()
            manager.notify(id,n)
        }

    }
}