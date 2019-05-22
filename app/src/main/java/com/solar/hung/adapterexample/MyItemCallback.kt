package com.solar.hung.adapterexample

import androidx.recyclerview.widget.DiffUtil

class MyItemCallback : DiffUtil.ItemCallback<RandomImage>() {

    override fun areItemsTheSame(oldItem: RandomImage, newItem: RandomImage): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: RandomImage, newItem: RandomImage): Boolean {
        return oldItem.textData == newItem.textData && oldItem.imageResource == newItem.imageResource
    }

}