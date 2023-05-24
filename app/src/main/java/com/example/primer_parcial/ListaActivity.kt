package com.example.primer_parcial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager


class ListaActivity : AppCompatActivity() {

    private lateinit var recyclerViewAlumnos: RecyclerView
    private lateinit var adapter: AlumnoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        val preferences = getSharedPreferences("alumnoPreference", MODE_PRIVATE)
        val nombrePref = preferences.getString("nombre", "")

        recyclerViewAlumnos = findViewById(R.id.recyclerViewAlumnos)
        recyclerViewAlumnos.layoutManager = LinearLayoutManager(this)

        adapter = AlumnoAdapter(applicationContext)
        recyclerViewAlumnos.adapter = adapter

        adapter.submitList(listadoDeAlumnos(nombrePref ?: ""))

        adapter.onItemClickListener = { alumno ->
            val intent = Intent(this, DetalleActivity::class.java)
            intent.putExtra("nombre", alumno.nombre)
            intent.putExtra("imagen", alumno.urlImagen)
            intent.putExtra("edad",alumno.edad.toString())
            startActivity(intent)
        }

    }

    private fun listadoDeAlumnos(nombre: String): MutableList<Alumno>{

        return mutableListOf(
            Alumno(1,nombre,25,"https://api.dicebear.com/6.x/personas/png?seed=Oliver"),
            Alumno(2,"Carlos",56,"https://api.dicebear.com/6.x/personas/png?seed=Boots"),
            Alumno(3,"Martina",18,"https://api.dicebear.com/6.x/personas/png?seed=Sammy"),
            Alumno(4,"Miguel",33,"https://api.dicebear.com/6.x/personas/png?seed=Shadow"),
            Alumno(5,"Carla",41,"https://api.dicebear.com/6.x/personas/png?seed=Ginger"),
            Alumno(6,"Jose",61,"https://api.dicebear.com/6.x/personas/png?seed=Tinkerbell"),
            Alumno(7,"Oscar",39,"https://api.dicebear.com/6.x/personas/png?seed=Snickers"),
            Alumno(8,"Thomas",35,"https://api.dicebear.com/6.x/personas/png?seed=Misty"),
            Alumno(9,"Santiago",20,"https://api.dicebear.com/6.x/personas/png?seed=Jack"),
            Alumno(10,"Jeremias",40,"https://api.dicebear.com/6.x/personas/png?seed=Willow"),

        )
    }
}