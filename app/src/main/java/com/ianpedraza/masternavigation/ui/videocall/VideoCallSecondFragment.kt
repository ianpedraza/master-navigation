package com.ianpedraza.masternavigation.ui.videocall

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ianpedraza.masternavigation.R
import com.ianpedraza.masternavigation.databinding.FragmentVideoCallSecondBinding

class VideoCallSecondFragment : Fragment() {

    private var _binding: FragmentVideoCallSecondBinding? = null
    private val binding: FragmentVideoCallSecondBinding get() = _binding!!

    private val args: VideoCallSecondFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVideoCallSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        binding.textViewVideoCallsSecondName.text =
            HtmlCompat.fromHtml(
                resources.getString(R.string.hello_name, args.name),
                HtmlCompat.FROM_HTML_MODE_COMPACT
            )

        binding.buttonVideoCallsSecondBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}
