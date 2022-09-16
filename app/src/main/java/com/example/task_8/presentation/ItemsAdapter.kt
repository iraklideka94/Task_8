package com.example.task_8.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.task_8.R
import com.example.task_8.databinding.ItemLayoutBinding
import com.example.task_8.model.Items

class ItemsAdapter : ListAdapter<Items, ItemsAdapter.OutfitViewHolder>(ItemsCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = OutfitViewHolder(
        ItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: OutfitViewHolder, position: Int) {
        holder.bind()
    }

    inner class OutfitViewHolder(private val binding: ItemLayoutBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val item = getItem(adapterPosition)
            binding.apply {
                tvTitle.text = item.title
                tvPrice.text = item.price
                val imageLink = item?.cover
                imageV.load(imageLink){
                    crossfade(true)
                    crossfade(1000)
                }
                if (item.liked == true) {
                    favImage.setImageResource(R.drawable.ic_baseline_favorite_24)
                } else {
                    favImage.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                }
            }
        }
    }

    private object ItemsCallback : DiffUtil.ItemCallback<Items>() {
        override fun areItemsTheSame(oldItem: Items, newItem: Items): Boolean {
            return oldItem.cover == newItem.cover
        }

        override fun areContentsTheSame(oldItem: Items, newItem: Items): Boolean {
            return oldItem == newItem
        }
    }

}