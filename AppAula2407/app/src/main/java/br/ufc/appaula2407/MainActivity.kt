package br.ufc.appaula2407

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.ufc.appaula2407.model.Cifra
import br.ufc.appaula2407.ui.theme.AppAula2407Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var edt = findViewById<EditText>(R.id.editTextText)
        var btn = findViewById<Button>(R.id.button)

        btn.setOnClickListener(){
            var intent1 = Intent(this,CifraActicity::class.java)
            intent1.putExtra("cifra", Cifra.criptografar(edt.text.toString()))
            startActivity(intent1)
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppAula2407Theme {
        Greeting("Android")
    }
}