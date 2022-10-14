package com.ianpedraza.masternavigation.ui.starred

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ianpedraza.masternavigation.databinding.FragmentStarredBinding

class StarredFragment : Fragment() {

    private var _binding: FragmentStarredBinding? = null
    private val binding: FragmentStarredBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStarredBinding.inflate(inflater, container, false)
        return binding.root
    }
}
