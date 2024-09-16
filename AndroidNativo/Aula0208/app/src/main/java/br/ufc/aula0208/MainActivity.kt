package br.ufc.aula0208

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.ufc.aula0208.ui.theme.Aula0208Theme

class MainActivity : ComponentActivity() {

    lateinit var edtName: EditText
    lateinit var edtAge: EditText
    lateinit var txtName: TextView
    lateinit var txtAge: TextView
    lateinit var btPesquisar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtName = findViewById(R.id.enterName)
        edtAge = findViewById(R.id.enterAge)
        txtName = findViewById(R.id.Name)
        txtAge = findViewById(R.id.Age)
        btPesquisar = findViewById(R.id.btPesquisar)

        btPesquisar.setOnClickListener {
            val db = DBHelper(this)

            var name: String = edtName.text.toString()
            val dbName = db.getName()

            txtName.setText(dbName.toString())
        }
    }

    fun addName(view: View){
        //Cria Helper do Banco de dados
        val db = DBHelper(this)
        // Cria variáveis para armazenar o nome e a idade digitados
        val name = edtName.text.toString()
        val age = edtAge.text.toString()
        // Chama o método para adicionar nome
        db.addName(name, age)

        // Notificação de que o nome foi adicionado no banco
        Toast.makeText(this, name + "added to database", Toast.LENGTH_LONG).show()
        clearField(edtName)
        clearField(edtAge)
    }

    fun clearField(editText: EditText){
        editText.text.clear()
    }

    @SuppressLint("Range")
    fun printName(view: View){
        val db = DBHelper(this)
        val cursor = db.getName()
        cursor!!.moveToFirst()

        txtName.append(cursor.getString
            (cursor.getColumnIndex("name")) + "\n")
        txtAge.append(cursor.getString
            (cursor.getColumnIndex(DBHelper.AGE_COL)) + "\n")

        while(cursor.moveToNext()){
            txtName.append(cursor.getString
                (cursor.getColumnIndex(DBHelper.NAME_COl)) + "\n")
            txtAge.append(cursor.getString
                (cursor.getColumnIndex(DBHelper.AGE_COL)) + "\n")
        }

        cursor.close()
    }

}