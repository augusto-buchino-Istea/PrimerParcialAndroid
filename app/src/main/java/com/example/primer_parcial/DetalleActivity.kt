package com.example.primer_parcial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide

class DetalleActivity : AppCompatActivity() {

    private lateinit var imageViewImagenDetalle: ImageView
    private lateinit var textViewNombreDetalle: TextView
    private lateinit var textViewEdadDetalle: TextView
    private lateinit var buttonAtras: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        imageViewImagenDetalle = findViewById(R.id.imageViewImagenDetalle)
        textViewNombreDetalle = findViewById(R.id.textViewNombreDetalle)
        textViewEdadDetalle = findViewById(R.id.textViewEdadDetalle)
        buttonAtras = findViewById(R.id.buttonAtras)

        val bundle = intent.extras
        val intentNombre = bundle?.getString("nombre", "")
        val intentImagen = bundle?.getString("imagen", "")
        val intentEdad = bundle?.getString("edad","")

        if(intentNombre.isNullOrBlank() || intentImagen.isNullOrBlank()){
            Toast.makeText(this, "No se encontro el alumno", Toast.LENGTH_LONG).show()
            val intent = Intent(this, ListaActivity::class.java)
            startActivity(intent)
        }

        Glide.with(applicationContext)
            .load(intentImagen)
            .into(imageViewImagenDetalle)

        textViewNombreDetalle.text = intentNombre
        textViewEdadDetalle.text = intentEdad

        buttonAtras.setOnClickListener{
            val intent = Intent(this, ListaActivity::class.java)
            startActivity(intent)
        }

    }
}