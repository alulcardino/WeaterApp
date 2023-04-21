package com.romanmikhailenko.weaterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.romanmikhailenko.weaterapp.databinding.ActivityMainBinding
import com.romanmikhailenko.weaterapp.databinding.FragmentHomeBinding

class MainActivity : AppCompatActivity() {


    private var _binding : ActivityMainBinding? = null
    private val mBinding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        val navController = this.findNavController(R.id.fragmentContainerView)
        // Find reference to bottom navigation view
        val navView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        // Hook your navigation controller to bottom navigation view
        navView.setupWithNavController(navController)

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}