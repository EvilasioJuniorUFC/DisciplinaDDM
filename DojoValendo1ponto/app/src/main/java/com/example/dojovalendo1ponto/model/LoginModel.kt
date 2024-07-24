package com.example.dojovalendo1ponto.model

import android.app.Activity
import android.widget.Toast

class LoginModel(val username: String?=null, val senha: String?=null)
{
    companion object
    {
        fun mensageFail(contexto: Activity) {
            Toast.makeText(contexto, "Login Failed", Toast.LENGTH_LONG).show()
        }

        val users: ArrayList<Pair<String, String>>
                = mutableListOf(Pair("joao", "123"), Pair("maria", "456"))
                as ArrayList<Pair<String, String>>
        fun verificaLogin(lm: LoginModel):Boolean{
            var check: Boolean = false
            for (user in users){
                if (user.first == lm.username && user.second == lm.senha)
                    check = true
            }
            return check
        }
    }

    fun mensageFail(contexto: Activity) {
        Toast.makeText(contexto, "Login Failed", Toast.LENGTH_LONG).show()
    }

    val users: ArrayList<Pair<String, String>>
    = mutableListOf(Pair("joao", "123"), Pair("maria", "456"))
            as ArrayList<Pair<String, String>>

    fun verificaLogin(lm: LoginModel):Boolean{
        var check: Boolean = false
        for (user in users){
            if (user.first == lm.username && user.second == lm.senha)
                check = true
        }
        return check
    }



}