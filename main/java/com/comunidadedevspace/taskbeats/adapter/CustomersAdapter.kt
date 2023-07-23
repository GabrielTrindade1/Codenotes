package com.comunidadedevspace.taskbeats.adapter

import Product
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.comunidadedevspace.taskbeats.R
import com.comunidadedevspace.taskbeats.removeAccents


class CustomerAdapter(private val products: List<Product>, private val onItemClick: (Product)->Unit) :
    RecyclerView.Adapter<CustomerAdapter.CustomerViewHolder>() , Filterable{

    val fullList = products
    var adapterList = fullList
    fun updateList(list: List<Product>) {
        adapterList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return CustomerViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CustomerViewHolder, position: Int) {
        val customer = adapterList[position]
        holder.bindCustomer(customer)
    }

    override fun getItemCount() = adapterList.size

    inner class CustomerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val idTextView: TextView = itemView.findViewById(R.id.tv_task_title)
        private val produtoTextView: TextView = itemView.findViewById(R.id.tv_task_description)
        private val root: LinearLayout = itemView.findViewById(R.id.root)

        fun bindCustomer(product: Product) {
            idTextView.text = product.id.toString()
            produtoTextView.text = product.produto
            root.setOnClickListener{
             onItemClick(product)
            }
        }
    }

    override fun getFilter(): Filter {
        return customFilter
    }
    val customFilter = object : Filter(){
        override fun performFiltering(Text: CharSequence?): FilterResults {
            val filteredList = mutableListOf<Product>()
            if (Text == null || Text.normalize().isEmpty()){
                filteredList.addAll(fullList)
            } else {
                fullList.forEach {
                    if (it.produto.normalize().contains(Text.normalize())){
                        filteredList.add(it)
                    }
                }
            }
            val results = FilterResults()
            results.values = filteredList
            return results
        }

        override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
            if (p1 != null) {
                updateList(p1.values as MutableList<Product>)
            }
        }

    }
    fun CharSequence.normalize() = trim().removeAccents().lowercase()
}



