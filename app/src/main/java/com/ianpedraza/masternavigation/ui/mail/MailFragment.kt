package com.ianpedraza.masternavigation.ui.mail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ianpedraza.masternavigation.databinding.FragmentMailBinding

class MailFragment : Fragment() {

    private var _binding: FragmentMailBinding? = null
    private val binding: FragmentMailBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonMailNext.setOnClickListener {
            findNavController().navigate(MailFragmentDirections.actionMailFragmentToMailSecondFragment())
        }

        // Without auto generated actions
        /*navController.navigate(
            R.id.localDestinationActivity
        )*/
    }
}
