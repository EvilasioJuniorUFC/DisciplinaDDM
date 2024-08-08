package br.ufc.aula0708.developer

import java.io.Serializable

class Developer (
    val name: String,
    val linguagem:String,
    val idade: Int,
    var foto:String,
    val biografia: String
): Serializable