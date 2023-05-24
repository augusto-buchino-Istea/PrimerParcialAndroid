package com.example.primer_parcial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var editTextPersonName: EditText
    private lateinit var buttonIngresar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextPersonName = findViewById(R.id.editTextPersonName)
        buttonIngresar = findViewById(R.id.buttonIngresar)

        buttonIngresar.setOnClickListener{
            if(editTextPersonName.text.isNullOrBlank()){
                Toast.makeText(this, "Debe ingresar un nombre", Toast.LENGTH_LONG).show()
            }else{

                val nombre = editTextPersonName.text.toString()

                val preferences = getSharedPreferences("alumnoPreference", MODE_PRIVATE)
                val editor = preferences.edit()
                editor.putString("nombre", nombre)
                editor.apply()

                val intent = Intent(this, ListaActivity::class.java)
                startActivity(intent)
            }

        }

    }
}