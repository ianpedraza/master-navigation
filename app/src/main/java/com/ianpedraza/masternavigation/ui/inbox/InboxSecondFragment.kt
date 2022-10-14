package com.ianpedraza.masternavigation.ui.inbox

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ianpedraza.masternavigation.databinding.FragmentInboxSecondBinding

class InboxSecondFragment : Fragment() {

    private var _binding: FragmentInboxSecondBinding? = null
    private val binding: FragmentInboxSecondBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInboxSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonInboxSecondNext.setOnClickListener {
            findNavController().navigate(InboxSecondFragmentDirections.actionInboxSecondFragmentToInboxThirdFragment())
        }

        binding.buttonInboxSecondBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}
