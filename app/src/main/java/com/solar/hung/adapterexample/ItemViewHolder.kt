package com.solar.hung.adapterexample

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imageView: ImageView = itemView.findViewById(R.id.imageView)
    val tvData: TextView = itemView.findViewById(R.id.tvData)
    val btnChangeText: Button = itemView.findViewById(R.id.btnChangeText)
    val btnChangeImage: Button = itemView.findViewById(R.id.btnChangeImage)

    fun onBind(data: RandomImage) {
        Glide.with(imageView)
            .load(data.imageResource)
            .into(imageView)
        imageView.visibility = View.GONE
        tvData.text = data.textData
        btnChangeImage.visibility = View.GONE
        btnChangeText.visibility = View.GONE
    }
}