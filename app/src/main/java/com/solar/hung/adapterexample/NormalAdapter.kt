package com.solar.hung.adapterexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NormalAdapter(private val listData: ArrayList<RandomImage>) : RecyclerView.Adapter<ItemViewHolder>() {
    private var inflater: LayoutInflater? = null
    private var listener: AdapterListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): ItemViewHolder {
        if (inflater == null) inflater = LayoutInflater.from(parent.context)
        return ItemViewHolder(inflater!!.inflate(R.layout.item_text, parent, false))
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.onBind(listData[position])

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