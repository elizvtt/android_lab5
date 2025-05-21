package com.example.lab5_palazova.task1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab5_palazova.R

class Adapter(
    private val items: List<Item>,
    private val onItemClick: (Int) -> Unit
) : RecyclerView.Adapter<Adapter.ItemViewHolder>(){

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val text: TextView = view.findViewById(R.id.textView)
        val container: View = view
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.items, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]


        holder.container.setBackgroundColor(item.color)  // Применяем случайный цвет


        // Устанавливаем значение текста
        holder.text.text = item.value.toString()

        // Обработчик нажатия
        holder.container.setOnClickListener {
            onItemClick(item.value)
        }
    }

    override fun getItemCount(): Int = items.size
}