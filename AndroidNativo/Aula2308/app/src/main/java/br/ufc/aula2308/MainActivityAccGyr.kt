package br.ufc.aula2308

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.app.ActivityCompat
import android.Manifest
import android.content.pm.PackageManager
import android.util.Log
import android.widget.Button
import android.widget.Toast

class MainActivityAccGyr : AppCompatActivity(),SensorEventListener {
    private var mAccelerometer : Sensor? = null
    private var mGyroscope : Sensor? = null

    private lateinit var accValue:String
    private lateinit var gyrValue:String
    private lateinit var sensorManager: SensorManager

    private lateinit var textviewAcc:TextView
    private lateinit var textviewGyr:TextView


    // ---- Coleta de dados de sensores de Acelerômetro e Giroscópio usando Listeners ---//
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_accgyr)

        //Initiate Sensor
        accValue = ""
        gyrValue = ""
        textviewAcc = findViewById(R.id.textViewAcc)
        textviewGyr = findViewById(R.id.textViewGyr)

        //requetPermission()
       // checkDevicePermission()
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        mAccelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        mGyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)

        var botao = findViewById<Button>(R.id.button)

        botao.setOnClickListener{
            Thread(Runnable { while(true) {

                runOnUiThread{
                    textviewGyr.text = "GYR: " + gyrValue.split(",")[0] + "\n" +
                        gyrValue.split(",")[1] + "\n" +
                        gyrValue.split(",")[2]
                textviewAcc.text = "ACC: " + accValue.split(",")[0] + "\n" +
                        accValue.split(",")[1] + "\n" +
                        accValue.split(",")[2]
                }

                Thread.sleep(10)
            }}).start()


        }
            //runOnUiThread{monitor.Monitoring()}

    }

    override fun onResume() {
        super.onResume()
        sensorManager!!.registerListener(this, mAccelerometer,
            SensorManager.SENSOR_DELAY_GAME)
        sensorManager!!.registerListener(this, mGyroscope,
            SensorManager.SENSOR_DELAY_GAME)
    }

    //---Executa ao para tela//


    //---Executa quando sensor muda o valor//
   override fun onSensorChanged(event: SensorEvent?) {
        if (event != null) {
            if(event.sensor.type == Sensor.TYPE_ACCELEROMETER)
                accValue =  collectData(event)
            if(event.sensor.type == Sensor.TYPE_GYROSCOPE)
                gyrValue = collectData(event)
        }
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
            return
    }

    private fun collectData(event: SensorEvent ?):String {
        val myData = event!!.values[0].toString()+","+event!!.values[1].toString() +","+event!!.values[2].toString()
        return myData
    }

    fun checkDevicePermission() : Boolean {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACTIVITY_RECOGNITION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACTIVITY_RECOGNITION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            Toast.makeText(this, "No Permissions", Toast.LENGTH_LONG).show()
            Log.i("Permissions", "Permissions Granted")
            return false
        } else {
            Log.i("Permissions", "Has permissions")
            //Toast.makeText(this, "Has Permissions", Toast.LENGTH_LONG).show()
            return true
        }

    }

    //Request Device Permissions
    //ADD Here the permissios needed for your app
    fun requetPermission(){
        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.BODY_SENSORS,
                Manifest.permission.ACTIVITY_RECOGNITION
            ),
            0
        )
        Log.i("Permissions", "Permissions Granted")
    }

}