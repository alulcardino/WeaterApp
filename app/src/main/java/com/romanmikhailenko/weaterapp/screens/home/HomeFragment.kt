package com.romanmikhailenko.weaterapp.screens.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.preference.PreferenceManager
import com.romanmikhailenko.weaterapp.data.model.city.Location
import com.romanmikhailenko.weaterapp.databinding.FragmentHomeBinding
import com.romanmikhailenko.weaterapp.screens.home.adapters.MainViewPagerAdapter
import com.romanmikhailenko.weaterapp.screens.home.model.Details
import com.romanmikhailenko.weaterapp.screens.home.model.Item
import com.romanmikhailenko.weaterapp.screens.home.model.MainInfo
import com.romanmikhailenko.weaterapp.utils.Resource
import com.romanmikhailenko.weaterapp.utils.TimeUtils
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.roundToInt


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val mBinding get() = _binding!!

    private val viewModel by viewModels<HomeViewModel>()
    private var adapter = MainViewPagerAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        mBinding.viewPager.adapter = adapter
//        adapter.setItems()
        return mBinding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onResume() {
        super.onResume()

        val listOfViewPager = mutableListOf<Item>()
        if (arguments != null) {
            viewModel.coord =  Location(
                (requireArguments().getDouble("lon") * 100.0).roundToInt() / 100.0,
                (requireArguments().getDouble("lat") * 100.0).roundToInt() / 100.0)

        }


        viewModel.setWeather()
        //viewModel.setForecast()

//        viewModel.forecastLiveData.observe(viewLifecycleOwner) { response ->
//            when (response) {
//                is Resource.Success -> {
//                   }
//                is Resource.Error -> {
//                    response.data?.let {
//                        Log.e("checkData", "error : $it")
//                    }
//                }
//                is Resource.Loading -> {
//                }
//            }
////        }
//
        viewModel.weatherLiveData.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Success -> {
                    listOfViewPager.add(0, MainInfo(
                        response.data?.main?.temp.toString(),
                        response.data?.main?.feels_like.toString(),
                        "icon",
                        response.data?.weather?.get(0)?.description.toString()
                    ))

                    listOfViewPager.add(1, Details(
                        TimeUtils.getTime(response.data?.sys?.sunrise ?: 0),
                        TimeUtils.getTime(response.data?.sys?.sunset ?: 0),
                        response.data?.main?.humidity.toString(),
                        response.data?.main?.pressure.toString(),
                        response.data?.visibility.toString(),
                        ))
                    adapter.setItems(listOfViewPager)
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
        listOfViewPager.clear()
    }

}