package com.romanmikhailenko.weaterapp.screens.location

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.romanmikhailenko.weaterapp.R
import com.romanmikhailenko.weaterapp.data.model.city.Location
import com.romanmikhailenko.weaterapp.data.model.city.UpdateCity
import com.romanmikhailenko.weaterapp.databinding.FragmentCitiesBinding
import com.romanmikhailenko.weaterapp.screens.location.adapters.CitiesAdapter
import com.romanmikhailenko.weaterapp.screens.location.adapters.SearchAdapter
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class CitiesFragment : Fragment() {
    private var _binding: FragmentCitiesBinding? = null
    private val mBinding get() = _binding!!

    private lateinit var mAdapter: CitiesAdapter

    private val viewModel by viewModels<LocationViewModel>()
    lateinit var coords : Location



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCitiesBinding.inflate(layoutInflater, container, false)
        mAdapter = CitiesAdapter(CitiesAdapter.OnClickListener {
            val args = Bundle()
            args.putString("city", it.name)
            args.putDouble("lat", it.lat!!)
            args.putDouble("lon", it.lon!!)
             findNavController().navigate(R.id.action_citiesFragment_to_home, args)
        })
        mBinding.tvSearchCity.setOnClickListener {
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