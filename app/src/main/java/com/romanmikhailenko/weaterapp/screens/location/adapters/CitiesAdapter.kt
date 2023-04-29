package com.romanmikhailenko.weaterapp.screens.location.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.romanmikhailenko.weaterapp.data.model.city.City
import com.romanmikhailenko.weaterapp.databinding.ItemSavedCityBinding
import com.romanmikhailenko.weaterapp.utils.DiffUtilCallback

class CitiesAdapter(
    private val onClickListener: OnClickListener
) : RecyclerView.Adapter<CitiesViewHolder>() {

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

    class OnClickListener(val clickListener: (city: City) -> Unit) {
        fun onClick(city: City) = clickListener(city)
    }

    override fun onBindViewHolder(holder: CitiesViewHolder, position: Int) {
        val city = differ.currentList[position]
        holder.itemView.setOnClickListener {
            onClickListener.onClick(city)
        }
        holder.bind(city)
    }

    override fun getItemCount() = differ.currentList.size


    private var onItemClickListener: ((City) -> Unit)? = null
    private var onParentItemClickListener: ((City) ->Unit)? = null


}
