package br.ufc.aula2308

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices


// ---- Coleta de dados de sLatitude e Longitude usando Location ---//
class MainActivityLatLng : AppCompatActivity() {
    val RequestPermissionCode = 1
    var mLocation: Location? = null
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private var latitude: TextView? = null
    private var longitude: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_lat_lng)
        latitude = findViewById(R.id.textView)
        longitude = findViewById(R.id.textView2)

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        getLastLocation()
    }

    fun getLastLocation() {


        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                RequestPermissionCode
            )

            Thread.sleep(5000)
        }
        else{
        fusedLocationProviderClient.lastLocation
                    .addOnSuccessListener { location: Location? ->
                        mLocation = location
                        if (location != null) {
                            latitude!!.text = location.latitude.toString()
                            longitude!!.text = location.longitude.toString()
                       }
                    }
        }

    }

}