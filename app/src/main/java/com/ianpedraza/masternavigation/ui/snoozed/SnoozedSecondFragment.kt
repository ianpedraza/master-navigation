package com.ianpedraza.masternavigation.ui.snoozed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ianpedraza.masternavigation.databinding.FragmentSnoozedSecondBinding

class SnoozedSecondFragment : Fragment() {

    private var _binding: FragmentSnoozedSecondBinding? = null
    private val binding: FragmentSnoozedSecondBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSnoozedSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSnoozedSecondNext.setOnClickListener {
            val action =
                SnoozedSecondFragmentDirections.actionSnoozedSecondFragmentToSnoozedThirdFragment2()
            findNavController().navigate(action)
        }
    }
}
