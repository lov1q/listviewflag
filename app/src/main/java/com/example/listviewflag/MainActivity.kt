package com.example.listviewflag

import android.app.ProgressDialog.show
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var countriesList: ListView
        val states = listOf(
            State("Россия", "Москва", R.drawable.ru),
            State("США", "Вашингтон", R.drawable.us),
            State("Австралия", "Канберра", R.drawable.au),
            State("Япония", "Токио", R.drawable.jp),
            State("Вьетнам", "Ханой", R.drawable.vn)
        )
        // получаем элемент ListView
        countriesList = findViewById<ListView>(R.id.countriesList)
        //создаем адаптер
        val stateAdapter = StateAdapter(this,R.layout.list_item, states)
        //устанавливаем адаптер
        countriesList.adapter=stateAdapter
        //слушатель выбора в списке
        val itemListener =
            OnItemClickListener { parent, v, position, id ->
                //получаем выбранный пункт
                val selectedState = parent.getItemAtPosition(position) as State
                Toast.makeText (applicationContext, "Был выбран пункт" + selectedState.getName(),
                Toast.LENGTH_SHORT).show()
            }
        countriesList.onItemClickListener = itemListener
    }
}