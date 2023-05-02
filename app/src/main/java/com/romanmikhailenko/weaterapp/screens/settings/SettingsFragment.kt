package com.romanmikhailenko.weaterapp.screens.settings

import android.content.res.Resources.Theme
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.preference.PreferenceFragmentCompat
import com.romanmikhailenko.weaterapp.R
import com.romanmikhailenko.weaterapp.databinding.FragmentHomeBinding
import com.romanmikhailenko.weaterapp.databinding.FragmentSettingsBinding

class SettingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }

}
