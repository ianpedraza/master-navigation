package com.ianpedraza.masternavigation.ui.snoozed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ianpedraza.masternavigation.databinding.FragmentSnoozedThirdBinding

class SnoozedThirdFragment : Fragment() {

    private var _binding: FragmentSnoozedThirdBinding? = null
    private val binding: FragmentSnoozedThirdBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSnoozedThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSnoozedSecondBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}
