package com.example.odontonavigationcomponent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.odontonavigationcomponent.databinding.FragmentPerfilBinding

class PerfilFragment : Fragment() {

    private var _binding: FragmentPerfilBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPerfilBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupClickListeners()
    }


    private fun setupClickListeners() {
        binding.btnEditarPerfil.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Botão meramente ilustrativo",
                Toast.LENGTH_LONG
            ).show()
        }
        binding.btnConfiguracoes.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Botão meramente ilustrativo",
                Toast.LENGTH_LONG
            ).show()
        }
        binding.btnSobre.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/UGVitor"))
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

