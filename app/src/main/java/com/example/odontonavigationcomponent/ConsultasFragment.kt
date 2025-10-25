package com.example.odontonavigationcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.odontonavigationcomponent.databinding.FragmentConsultasBinding
import java.text.SimpleDateFormat
import java.util.*

class ConsultasFragment : Fragment() {

    private var _binding: FragmentConsultasBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConsultasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.fabNovaConsulta.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Botão meramente ilustrativo",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun setupRecyclerView() {
        val consultas = listOf(
            Consulta("1", "João Silva", "15/01/2024", "14:30", "Limpeza"),
            Consulta("2", "Maria Santos", "16/01/2024", "09:00", "Ortodontia"),
            Consulta("3", "Pedro Oliveira", "17/01/2024", "16:00", "Canal"),
            Consulta("4", "Ana Costa", "18/01/2024", "10:30", "Implante"),
            Consulta("5", "Carlos Ferreira", "19/01/2024", "15:00", "Extração")
        )
        binding.recyclerViewConsultas.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(requireContext())

        binding.recyclerViewConsultas.adapter = ConsultasAdapter(consultas) { consulta ->
            val action = ConsultasFragmentDirections.actionConsultasFragmentToConsultaDetailFragment(
                consultaId = consulta.id,
                pacienteNome = consulta.pacienteNome,
                dataConsulta = consulta.data
            )
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

data class Consulta(
    val id: String,
    val pacienteNome: String,
    val data: String,
    val hora: String,
    val tipo: String
)
