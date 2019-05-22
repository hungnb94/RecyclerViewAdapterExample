package com.solar.hung.adapterexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.ListAdapter
import java.util.concurrent.Executors

class BetterAdapter : ListAdapter<RandomImage, ItemViewHolder>(
        AsyncDifferConfig.Builder<RandomImage>(MyItemCallback())
                .setBackgroundThreadExecutor(Executors.newSingleThreadExecutor())
                .build()
) {
    private var inflater: LayoutInflater? = null
    private var listener: AdapterListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        if (inflater == null) inflater = LayoutInflater.from(parent.context)
        return ItemViewHolder(inflater!!.inflate(R.layout.item_text, parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.onBind(getItem(position))

        holder.btnChangeText.setOnClickListener {
            listener?.onChangeText(holder.adapterPosition)
        }
        holder.btnChangeImage.setOnClickListener {
            listener?.onChangeImage(holder.adapterPosition)
        }
    }

    fun setAdapterListener(listener: AdapterListener) {
        this.listener = listener
    }

}