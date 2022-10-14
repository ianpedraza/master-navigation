package com.ianpedraza.masternavigation.ui.inbox

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ianpedraza.masternavigation.databinding.FragmentInboxThirdBinding
import com.ianpedraza.masternavigation.ui.mail.MailFragmentDirections

class InboxThirdFragment : Fragment() {

    private var _binding: FragmentInboxThirdBinding? = null
    private val binding: FragmentInboxThirdBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInboxThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonInboxThirdBack.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.buttonInboxExit.setOnClickListener {
            // Global actions
            val globalAction = MailFragmentDirections.actionNavGraphHomePop()
            findNavController().navigate(globalAction)
        }
    }
}
