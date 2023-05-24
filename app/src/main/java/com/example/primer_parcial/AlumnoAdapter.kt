package com.example.primer_parcial

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AlumnoAdapter (val context: Context) : ListAdapter<Alumno, AlumnoAdapter.ViewHolder>(DiffCallBack){

    lateinit var onItemClickListener: (Alumno) -> Unit

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val textViewNombre : TextView = view.findViewById(R.id.textViewNombre)
        private val textViewEdad : TextView = view.findViewById(R.id.textViewEdad)
        private val imageViewFoto: ImageView = view.findViewById(R.id.imageViewFoto)

        fun bind(alumno: Alumno){
            textViewNombre.text = alumno.nombre
            textViewEdad.text = alumno.edad.toString()

            Glide.with(context)
                .load(alumno.urlImagen)
                .into(imageViewFoto)

            view.setOnClickListener{
                onItemClickListener(alumno)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlumnoAdapter.ViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.personslist, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlumnoAdapter.ViewHolder, position: Int) {
        val alumno = getItem(position)
        holder.bind(alumno)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Alumno>() {
        override fun areItemsTheSame(oldItem: Alumno, newItem: Alumno): Boolean {
            return  oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Alumno, newItem: Alumno): Boolean {
            return oldItem == newItem
        }
    }

}