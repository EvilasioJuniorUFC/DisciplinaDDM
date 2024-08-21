package br.ufc.aula1408

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar


class MenuOptionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_options)

        //val toolbar: Toolbar = findViewById(R.id.toolbar2)
        //setSupportActionBar(toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.optionsmenu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item!!.itemId){
            R.id.item1 -> Toast.makeText(this, "Item 1", Toast.LENGTH_SHORT).show()
            R.id.item2 -> Toast.makeText(this, "Item 2", Toast.LENGTH_SHORT).show()
            R.id.item3 -> Toast.makeText(this, "Item 3", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}