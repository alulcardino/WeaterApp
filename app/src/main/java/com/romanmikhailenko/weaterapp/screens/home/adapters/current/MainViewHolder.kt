package com.romanmikhailenko.weaterapp.screens.home.adapters.current

import android.util.Log
import android.widget.ImageView
import com.romanmikhailenko.weaterapp.R
import com.romanmikhailenko.weaterapp.databinding.ItemWeatherMainBinding
import com.romanmikhailenko.weaterapp.screens.home.model.MainInfo
import com.romanmikhailenko.weaterapp.utils.Constants.Companion.MAP_ICONS
import com.squareup.picasso.Picasso
import timber.log.Timber


class MainViewHolder(
    private val binding: ItemWeatherMainBinding
) : ViewHolderItem(binding.root) {

    fun bind(item: MainInfo) = with(binding) {
        val resID = binding.root.context.resources.getIdentifier("${MAP_ICONS[item.icon]}", "drawable", root.context.packageName)
        icon.setImageResource(resID)
        temp.text = item.temp
        desc.text = item.description
        tvCityName.text = item.city
    }

}