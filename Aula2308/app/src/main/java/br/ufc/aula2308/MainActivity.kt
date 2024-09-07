package br.ufc.aula2308

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions


// ---- Usando API do Google Maps ---//

class MainActivity : AppCompatActivity() {
    val RequestPermissionCode = 1
    var mLocation: Location? = null
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    lateinit var latitude: String
    lateinit var longitude: String

    private var places = arrayListOf(
        Place("UFC", LatLng(-3.6935704,-40.3575019), "R. Cel. Estanislau Frota, 563 - Centro, Sobral - CE, 62010-560")
  )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Av. Cmte. Maurocélio Rocha Pontes, 100 - Jocely Dantas de Andrade Torres, Sobral - CE, 62042-250
        //R. Cel. Estanislau Frota, 563 - Centro, Sobral - CE, 62010-560 - -3.6935704,-40.3575019

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        getLastLocation()
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map_fragment) as SupportMapFragment

        mapFragment.getMapAsync{googleMap ->
            addMarkers(googleMap)

            googleMap.setOnMapLoadedCallback {
                val bounds = LatLngBounds.builder()
                places.forEach{
                    bounds.include(it.latlng)
                }

                googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds.build(), 100))
            }
        }
    }

    private fun addMarkers(googleMap: GoogleMap){
            places.forEach{place->
                val marker = googleMap.addMarker(
                     MarkerOptions(). title(place.name)
                        .snippet(place.address)
                        .position(place.latlng)
                         .icon(BitMapHelper.vectorToBitmap(this,
                             R.drawable.ic_android_black_24dp, ContextCompat.getColor(this, R.color.green)))

                )
            }
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
                        places.add(Place("Minha localização",
                            LatLng(location.latitude, location.longitude),
                            "Minha Localização"))
                    }
                }
        }

    }

}

data class Place(
    val name: String,
    val latlng:LatLng,
    val address: String
)