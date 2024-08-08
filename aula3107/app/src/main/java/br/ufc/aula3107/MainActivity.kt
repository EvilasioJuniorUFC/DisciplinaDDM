package br.ufc.aula3107

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import br.ufc.aula3107.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {

    lateinit var texto:TextView
    lateinit var texto2:TextView
    lateinit var texto3:TextView
    lateinit var texto4:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        texto = findViewById(R.id.textView)
        texto2 = findViewById(R.id.textView2)
        texto3 = findViewById(R.id.textView3)
        texto4 = findViewById(R.id.textView4)

        /*val time = measureTimeMillis{
        runBlocking {
            texto.text = "Previsão do Tempo"
            mostrarPrevisaoTempo()
            mostrarTemperatura()
        }}
        texto4.text = "Tempo de Execução: ${time / 1000.0} seconds"
*/
        /*
        val time = measureTimeMillis{
            runBlocking {
                texto.text = "Previsão do Tempo"
                launch {mostrarPrevisaoTempo()}
                launch {mostrarTemperatura()}
            }
        }
        texto4.text = "Tempo de Execução: ${time / 1000.0} seconds"
*/
    /*
        val time = measureTimeMillis{
            runBlocking {
                texto.text = "Previsão do Tempo"
                val forecast: Deferred<String> = async {mostrarPrevisaoTempo()}
                val temperature: Deferred<String> = async {mostrarTemperatura()}
                        texto2.text = "${forecast.await()}"
                        texto3.text = "${temperature.await()}"
            }}
        texto4.text = "Tempo de Execução: ${time / 1000.0} seconds"
*/
        val time = measureTimeMillis{
            runBlocking {
                texto.text = "Previsão do Tempo"
                texto2.text = ""
                texto3.text = getWeatherReport()
            }}
        texto4.text = "Tempo de Execução: ${time / 1000.0} seconds"

            var tr = testeRunnable()
            Thread(tr).start();
    }

    suspend fun getWeatherReport() = coroutineScope {
        val forecast: Deferred<String> = async {mostrarPrevisaoTempo()}
        val temperature: Deferred<String> = async {mostrarTemperatura()}
        "${forecast.await()} ${temperature.await()}"
    }

    suspend fun mostrarPrevisaoTempo():String {
        delay(1000)
        //texto2.text = "Céu Ensolarado"
        return "Céu Ensolarado"
    }
    suspend fun mostrarTemperatura():String {
            delay(1000)
           // texto3.text = "30º"
            return "30º"
    }

}