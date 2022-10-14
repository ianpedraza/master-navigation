package com.ianpedraza.masternavigation.ui.videocall

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ianpedraza.masternavigation.databinding.FragmentVideoCallBinding

class VideoCallFragment : Fragment() {

    private var _binding: FragmentVideoCallBinding? = null
    private val binding: FragmentVideoCallBinding get() = _binding!!

    private val viewModel: VideoCallViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVideoCallBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        subscribeObservers()
    }

    private fun setupUI() {
        binding.textInputEditTextName.addTextChangedListener {
            viewModel.setName(it.toString())
        }

        binding.buttonVideoCallsNext.setOnClickListener {
            viewModel.navigate()
        }
    }

    private fun subscribeObservers() {
        viewModel.isButtonEnabled.observe(viewLifecycleOwner) { isButtonEnabled ->
            binding.buttonVideoCallsNext.isEnabled = isButtonEnabled
        }

        viewModel.navigate.observe(viewLifecycleOwner) { name ->
            if (name != null) {
                findNavController().navigate(
                    VideoCallFragmentDirections.actionVideoCallFragmentToVideoCallSecondFragment(
                        name
                    )
                )

                // Without auto generated actions
                /*
                navController.navigate(
                    R.id.localDestinationActivity,
                    bundleOf("userId" to "someUser")
                )
                */

                viewModel.onNavigated()
                binding.textInputEditTextName.text = null
            }
        }
    }
}
