package com.romanmikhailenko.weaterapp.screens.location

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.romanmikhailenko.weaterapp.R
import com.romanmikhailenko.weaterapp.databinding.FragmentHomeBinding
import com.romanmikhailenko.weaterapp.databinding.FragmentLocationBinding

class LocationFragment : Fragment() {
    private var _binding : FragmentLocationBinding? = null
    private val mBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLocationBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}