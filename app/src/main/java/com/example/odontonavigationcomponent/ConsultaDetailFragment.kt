package com.example.odontonavigationcomponent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.odontonavigationcomponent.databinding.FragmentConsultaDetailBinding

class ConsultaDetailFragment : Fragment() {

    private var _binding: FragmentConsultaDetailBinding? = null
    private val binding get() = _binding!!

    private val args: ConsultaDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConsultaDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupConsultaInfo()
        setupClickListeners()
    }

    private fun setupConsultaInfo() {
        binding.textViewPacienteNome.text = args.pacienteNome
        binding.textViewDataConsulta.text = args.dataConsulta
        binding.textViewConsultaId.text = "ID: ${args.consultaId}"

        binding.textViewHoraConsulta.text = "14:30"
        binding.textViewTipoConsulta.text = "Limpeza Dental"
        binding.textViewStatusConsulta.text = "Agendada"
        binding.textViewObservacoes.text = "Paciente com sensibilidade nos dentes anteriores. Usar anestésico tópico."
    }

    private fun setupClickListeners() {
        binding.btnConfirmarConsulta.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Botão meramente ilustrativo",
                Toast.LENGTH_LONG
            ).show()
        }

        binding.btnCancelarConsulta.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Botão meramente ilustrativo",
                Toast.LENGTH_LONG
            ).show()
        }

        binding.btnReagendarConsulta.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Botão meramente ilustrativo",
                Toast.LENGTH_LONG
            ).show()
        }

        binding.btnAdicionarObservacoes.setOnClickListener {
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

