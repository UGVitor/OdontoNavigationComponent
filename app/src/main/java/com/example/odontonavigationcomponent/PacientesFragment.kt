package com.example.odontonavigationcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.odontonavigationcomponent.databinding.FragmentPacientesBinding

class PacientesFragment : Fragment() {

    private var _binding: FragmentPacientesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPacientesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.fabAdicionarPaciente.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Botão meramente ilustrativo",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun setupRecyclerView() {
        val pacientes = listOf(
            Paciente("1", "João Silva", "joao@email.com", "11999999999"),
            Paciente("2", "Maria Santos", "maria@email.com", "11888888888"),
            Paciente("3", "Pedro Oliveira", "pedro@email.com", "11777777777"),
            Paciente("4", "Ana Costa", "ana@email.com", "11666666666"),
            Paciente("5", "Carlos Ferreira", "carlos@email.com", "11555555555"),
            Paciente("6", "Lucia Mendes", "lucia@email.com", "11444444444")
        )

        binding.recyclerViewPacientes.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(requireContext())

        binding.recyclerViewPacientes.adapter = PacientesAdapter(pacientes) { paciente ->
            val action = PacientesFragmentDirections.actionPacientesFragmentToPacienteDetailFragment(
                pacienteId = paciente.id,
                pacienteNome = paciente.nome
            )
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

data class Paciente(
    val id: String,
    val nome: String,
    val email: String,
    val telefone: String
)
