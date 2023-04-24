package com.romanmikhailenko.weaterapp.screens.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.preference.PreferenceManager
import com.romanmikhailenko.weaterapp.databinding.FragmentHomeBinding
import com.romanmikhailenko.weaterapp.utils.Resource
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val mBinding get() = _binding!!

    private val viewModel by viewModels<HomeViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        return mBinding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onResume() {
        super.onResume()


        viewModel.setWeather()
        viewModel.setForecast()



        viewModel.forecastLiveData.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    mBinding.textView.text = response.data?.list?.get(12)?.dt_txt
                }
                is Resource.Error -> {
                    response.data?.let {
                        Log.e("checkData", "error : $it")
                    }
                }
                is Resource.Loading -> {
                }
            }
        }

        viewModel.weatherLiveData.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    mBinding.textView2.text = response.data?.dt.toString()
                }
                is Resource.Error -> {
                    response.data?.let {
                        Log.e("checkData", "error : $it")
                    }
                }
                is Resource.Loading -> {
                }
            }
        }
    }


}