package com.romanmikhailenko.weaterapp.screens.home.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.romanmikhailenko.weaterapp.databinding.ItemWeatherDetailsBinding
import com.romanmikhailenko.weaterapp.databinding.ItemWeatherMainBinding
import com.romanmikhailenko.weaterapp.screens.home.model.Details
import com.romanmikhailenko.weaterapp.screens.home.model.Item
import com.romanmikhailenko.weaterapp.screens.home.model.MainInfo

const val VIEW_TYPE_MAIN = 0
const val VIEW_TYPE_DETAILS = 1;

class MainViewPagerAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var pages = listOf<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_MAIN) {
            MainViewHolder(ItemWeatherMainBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        } else {
            DetailsViewHolder(ItemWeatherDetailsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == VIEW_TYPE_MAIN) VIEW_TYPE_MAIN else VIEW_TYPE_DETAILS
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d("sho", position.toString())
        when (holder) {
            is MainViewHolder -> holder.bind(pages[position] as MainInfo)
            is DetailsViewHolder -> holder.bind(pages[position] as Details)
        }
    }

    override fun getItemCount() = pages.size

    fun setItems(newItems: List<Item>) {
        pages = newItems.toList()
        notifyDataSetChanged()
    }
}