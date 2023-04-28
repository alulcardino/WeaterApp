package com.romanmikhailenko.weaterapp.screens.cities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.romanmikhailenko.weaterapp.R
import com.romanmikhailenko.weaterapp.databinding.FragmentCitiesBinding
import com.romanmikhailenko.weaterapp.screens.cities.adapters.CitiesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CitiesFragment : Fragment() {
    private var _binding: FragmentCitiesBinding? = null
    private val mBinding get() = _binding!!

    private lateinit var mAdapter: CitiesAdapter

    private val viewModel by viewModels<CitiesViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCitiesBinding.inflate(layoutInflater, container, false)
        mAdapter = CitiesAdapter()
        mBinding.button.setOnClickListener {
            findNavController().navigate(R.id.action_citiesFragment_to_location)
        }
        setUpRecyclerView()
        setUpObservers()
        return mBinding.root
    }

    private fun setUpRecyclerView() {
        mBinding.rvSavedCity.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            setHasFixedSize(true)
            adapter = mAdapter
        }
    }

    private fun setUpObservers() {
        viewModel.getSavedCities(1).observe(viewLifecycleOwner) { cities ->
            mAdapter.differ.submitList(cities)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}