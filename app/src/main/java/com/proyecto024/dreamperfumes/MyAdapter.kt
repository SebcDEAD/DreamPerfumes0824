package com.proyecto024.dreamperfumes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.proyecto024.dreamperfumes.databinding.ItemLayoutBinding

class MyAdapter(private var items: List<String> = listOf()) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    // Actualiza los datos en el adaptador
    fun updateData(newItems: List<String>) {
        items = newItems
        notifyDataSetChanged()
    }

    // Realiza la búsqueda (esto es solo un ejemplo)
    fun performSearch(query: String) {
        // Filtra los resultados según la búsqueda
        val filteredItems = items.filter { it.contains(query, ignoreCase = true) }
        updateData(filteredItems)
    }

    // Filtra los resultados en tiempo real
    fun filterResults(newText: String) {
        // Filtra los resultados según el texto ingresado
        val filteredItems = items.filter { it.contains(newText, ignoreCase = true) }
        updateData(filteredItems)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(private val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            binding.textView.text = item
        }
    }
}

