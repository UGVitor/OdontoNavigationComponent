package com.example.odontonavigationcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.odontonavigationcomponent.databinding.FragmentPacienteDetailBinding

class PacienteDetailFragment : Fragment() {

    private var _binding: FragmentPacienteDetailBinding? = null
    private val binding get() = _binding!!
    
    // Usando Safe Args para receber os argumentos de forma segura
    private val args: PacienteDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPacienteDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupPatientInfo()
        setupClickListeners()
    }

    private fun setupPatientInfo() {
        // Usando os argumentos recebidos via Safe Args
        binding.textViewPacienteNome.text = args.pacienteNome
        binding.textViewPacienteId.text = "ID: ${args.pacienteId}"
        
        // Informações simuladas do paciente
        binding.textViewEmail.text = "email@exemplo.com"
        binding.textViewTelefone.text = "(11) 99999-9999"
        binding.textViewDataNascimento.text = "01/01/1990"
        binding.textViewEndereco.text = "Rua Exemplo, 123 - São Paulo/SP"
        binding.textViewHistoricoMedico.text = "Nenhuma alergia conhecida. Histórico de cáries tratadas."
    }

    private fun setupClickListeners() {
        binding.btnAgendarConsulta.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Botão meramente ilustrativo",
                Toast.LENGTH_LONG
            ).show()

        }

        binding.btnEditarPaciente.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Botão meramente ilustrativo",
                Toast.LENGTH_LONG
            ).show()

        }

        binding.btnVerHistorico.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Botão meramente ilustrativo",
                Toast.LENGTH_LONG
            ).show()

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

