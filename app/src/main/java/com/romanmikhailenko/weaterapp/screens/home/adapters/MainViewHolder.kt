package com.romanmikhailenko.weaterapp.screens.home.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.romanmikhailenko.weaterapp.databinding.ItemWeatherMainBinding
import com.romanmikhailenko.weaterapp.screens.home.model.MainInfo

class MainViewHolder(
    private val binding: ItemWeatherMainBinding
) : ViewHolderItem(binding.root) {
     fun bind(item: MainInfo) = with(binding) {
         textView2.text = item.description
         textView3.text = item.feelsLike
     }

}