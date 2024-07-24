package com.example.dojovalendo1ponto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.dojovalendo1ponto.model.LoginModel

class LoginActivity : AppCompatActivity() {
    lateinit var editTextText: EditText
    lateinit var editTextText2: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var loginb: Button = findViewById(R.id.loginb)

        editTextText = findViewById(R.id.editTextText)
        editTextText2 = findViewById(R.id.editTextText2)

        loginb.setOnClickListener(){
            var loginModel = LoginModel()
            val isChcecked = loginModel.verificaLogin(LoginModel(editTextText.text.toString(), editTextText2.text.toString()))

            if (isChcecked){
                val ilogin = Intent(this, MainActivity::class.java)
                ilogin.putExtra("name", editTextText.text.toString())
                startActivity(ilogin)
            }
            else{
                LoginModel.mensageFail(this)
                //loginModel.mensageFail(this)
                //Toast.makeText(this,"Login failed",Toast.LENGTH_LONG).show()
            }

        }
    }

}