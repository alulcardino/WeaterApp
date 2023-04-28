package com.romanmikhailenko.weaterapp.screens.location.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.romanmikhailenko.weaterapp.data.model.city.City
import com.romanmikhailenko.weaterapp.databinding.ItemCityBinding
import com.romanmikhailenko.weaterapp.utils.DiffUtilCallback

class SearchAdapter() : RecyclerView.Adapter<SearchViewHolder>() {

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
