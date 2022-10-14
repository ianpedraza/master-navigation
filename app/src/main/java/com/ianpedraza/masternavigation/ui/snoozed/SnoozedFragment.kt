package com.ianpedraza.masternavigation.ui.snoozed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.ianpedraza.masternavigation.databinding.FragmentSnoozedBinding

class SnoozedFragment : Fragment() {

    private var _binding: FragmentSnoozedBinding? = null
    private val binding: FragmentSnoozedBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSnoozedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSnoozedStart.setOnClickListener {
            val action = SnoozedFragmentDirections.actionSnoozedFragmentToSnoozedSecondFragment()
            findNavController().navigate(
                action,
                // Animations in Kotlin code
                navOptions { // Use the Kotlin DSL for building NavOptions
                    anim {
                        enter = android.R.animator.fade_in
                        exit = android.R.animator.fade_out
                    }
                }
            )
        }
    }
}
