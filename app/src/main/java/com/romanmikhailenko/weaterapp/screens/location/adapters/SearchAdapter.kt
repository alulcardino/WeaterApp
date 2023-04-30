package com.romanmikhailenko.weaterapp.screens.location.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.romanmikhailenko.weaterapp.data.model.city.City
import com.romanmikhailenko.weaterapp.databinding.ItemCityBinding

class SearchAdapter(
    private val onClickListener: OnClickListener
) : RecyclerView.Adapter<SearchViewHolder>() {

    val differ = AsyncListDiffer(this, DiffUtilCallback())



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(
            ItemCityBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }



    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val city = differ.currentList[position]
        holder.itemView.setOnClickListener {
            onClickListener.onClick(city)
        }
        holder.bind(city)
    }

    override fun getItemCount() = differ.currentList.size

    class OnClickListener(val clickListener: (city: City) -> Unit) {
        fun onClick(city: City) = clickListener(city)
    }

    private var onParentItemClickListener: ((City) ->Unit)? = null

    fun setOnParentClickListener(listener: (City) -> Unit) {
        onParentItemClickListener = listener
    }

}
