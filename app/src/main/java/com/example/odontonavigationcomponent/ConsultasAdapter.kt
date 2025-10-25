package com.example.odontonavigationcomponent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ConsultasAdapter(
    private val consultas: List<Consulta>,
    private val onConsultaClick: (Consulta) -> Unit
) : RecyclerView.Adapter<ConsultasAdapter.ConsultaViewHolder>() {

    class ConsultaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewPacienteNome: TextView = view.findViewById(R.id.textViewPacienteNome)
        val textViewData: TextView = view.findViewById(R.id.textViewData)
        val textViewHora: TextView = view.findViewById(R.id.textViewHora)
        val textViewTipo: TextView = view.findViewById(R.id.textViewTipo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConsultaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_consulta, parent, false)
        return ConsultaViewHolder(view)
    }

    override fun onBindViewHolder(holder: ConsultaViewHolder, position: Int) {
        val consulta = consultas[position]
        holder.textViewPacienteNome.text = consulta.pacienteNome
        holder.textViewData.text = consulta.data
        holder.textViewHora.text = consulta.hora
        holder.textViewTipo.text = consulta.tipo
        
        holder.itemView.setOnClickListener {
            onConsultaClick(consulta)
        }
    }

    override fun getItemCount() = consultas.size
}

