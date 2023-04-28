package com.romanmikhailenko.weaterapp.screens.cities.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.romanmikhailenko.weaterapp.data.model.city.City
import com.romanmikhailenko.weaterapp.databinding.ActivityMainBinding.inflate
import com.romanmikhailenko.weaterapp.databinding.ItemSavedCityBinding
import com.romanmikhailenko.weaterapp.databinding.ItemWeatherMainBinding.inflate
import com.romanmikhailenko.weaterapp.screens.location.adapters.SearchViewHolder
import com.romanmikhailenko.weaterapp.utils.DiffUtilCallback

class CitiesAdapter() : RecyclerView.Adapter<CitiesViewHolder>() {

    val differ = AsyncListDiffer(this, DiffUtilCallback())

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitiesViewHolder {
        return CitiesViewHolder(
            ItemSavedCityBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            )
        )
    }


    override fun onBindViewHolder(holder: CitiesViewHolder, position: Int) {
        holder.bind(differ.currentList[position])
    }

    override fun getItemCount() = differ.currentList.size


    private var onItemClickListener: ((City) -> Unit)? = null
    private var onParentItemClickListener: ((City) ->Unit)? = null

    fun setOnParentClickListener(listener: (City) -> Unit) {
        onItemClickListener = listener
    }

    fun setOnItemClickListener(listener: (City) -> Unit) {
        onParentItemClickListener = listener
    }

}
