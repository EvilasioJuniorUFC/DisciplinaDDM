package br.ufc.appaula2407.model

class Cifra {
    companion object{

        fun criptografar(texto:String):String{
            var result = ""
            for(c in texto){
                result = result+(c.toInt()+2).toChar()
            }
            return result
        }
    }
}