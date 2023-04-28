package com.romanmikhailenko.weaterapp.utils

import androidx.recyclerview.widget.DiffUtil
import com.romanmikhailenko.weaterapp.data.model.city.City

class DiffUtilCallback : DiffUtil.ItemCallback<City>() {
    override fun areItemsTheSame(oldItem: City, newItem: City): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: City, newItem: City): Boolean {
        return oldItem == newItem
    }

}