package com.romanmikhailenko.weaterapp.screens.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.preference.PreferenceManager
import com.romanmikhailenko.weaterapp.R
import com.romanmikhailenko.weaterapp.databinding.FragmentHomeBinding
import com.romanmikhailenko.weaterapp.utils.Resource
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding : FragmentHomeBinding? = null
    private val mBinding get() = _binding!!

    private val viewModel by viewModels<HomeViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        val sharedPreferences = context?.let { PreferenceManager.getDefaultSharedPreferences(it) }

        mBinding.textView.text = sharedPreferences?.getString("units", "")
        return mBinding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//         viewModel.weatherLiveData.observe(viewLifecycleOwner) { response ->
//             when (response) {
//                 is Resource.Success -> {
//                     mBinding.textView.text = response.data?.main?.feels_like.toString()
//                 }
//                 is Resource.Error -> {
//                     response.data?.let {
//                         Log.e("checkData", "error : $it")
//                     }
//                 }
//                 is Resource.Loading -> {
//                 }
//             }
//         }

        loadSettings()
    }

    private fun loadSettings() {
        mBinding.textView.text = viewModel.getSharedPreferencesSettings().getString("units", "")

    }


}