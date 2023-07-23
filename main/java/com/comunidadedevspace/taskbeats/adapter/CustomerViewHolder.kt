package com.comunidadedevspace.taskbeats.adapter

import Product
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.comunidadedevspace.taskbeats.R

class CustomerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val idTextView: TextView = itemView.findViewById(R.id.tv_task_title)
    private val produtoTextView: TextView = itemView.findViewById(R.id.tv_task_description)


    fun bind(product: Product) {
        idTextView.text = product.id.toString()
        produtoTextView.text = product.produto

    }
}
