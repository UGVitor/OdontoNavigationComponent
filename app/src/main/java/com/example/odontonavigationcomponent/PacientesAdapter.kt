package com.example.odontonavigationcomponent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PacientesAdapter(
    private val pacientes: List<Paciente>,
    private val onPacienteClick: (Paciente) -> Unit
) : RecyclerView.Adapter<PacientesAdapter.PacienteViewHolder>() {

    class PacienteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewNome: TextView = view.findViewById(R.id.textViewPacienteNome)
        val textViewEmail: TextView = view.findViewById(R.id.textViewPacienteEmail)
        val textViewTelefone: TextView = view.findViewById(R.id.textViewPacienteTelefone)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PacienteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_paciente, parent, false)
        return PacienteViewHolder(view)
    }

    override fun onBindViewHolder(holder: PacienteViewHolder, position: Int) {
        val paciente = pacientes[position]
        holder.textViewNome.text = paciente.nome
        holder.textViewEmail.text = paciente.email
        holder.textViewTelefone.text = paciente.telefone
        
        holder.itemView.setOnClickListener {
            onPacienteClick(paciente)
        }
    }

    override fun getItemCount() = pacientes.size
}

