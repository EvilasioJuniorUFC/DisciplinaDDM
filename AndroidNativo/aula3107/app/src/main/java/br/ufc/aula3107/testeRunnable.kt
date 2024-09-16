package br.ufc.aula3107

import android.util.Log

class testeRunnable : Runnable {
    override fun run() {
        Log.i("Script", "Runnable Thread")

    }
}