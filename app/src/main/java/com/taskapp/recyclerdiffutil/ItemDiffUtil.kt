package com.taskapp.recyclerdiffutil

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil

class ItemDiffUtil : DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(
        oldItem: Item,
        newItem: Item
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(
        oldItem: Item,
        newItem: Item
    ): Boolean {

        return oldItem == newItem

    }
}