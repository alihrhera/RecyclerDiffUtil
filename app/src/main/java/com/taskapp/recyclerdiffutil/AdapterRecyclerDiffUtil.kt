package com.taskapp.recyclerdiffutil

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.taskapp.recyclerdiffutil.databinding.RowOneItemBinding
import java.util.ArrayList

class AdapterRecyclerDiffUtil :
    ListAdapter<Item, AdapterRecyclerDiffUtil.MViewHolder>(ItemDiffUtil()) {
    private var dataList: MutableList<Item> = ArrayList()

    fun setDataList(listOfData: MutableList<Item>) {
        dataList = listOfData
        submitList(listOfData)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MViewHolder {
        val row: RowOneItemBinding = RowOneItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return MViewHolder(row)
    }

    override fun onBindViewHolder(holder: MViewHolder, position: Int) {
        val item = getItem(position)
        val bind = holder.binding

        bind.root.setOnClickListener {
            val pos=dataList.indexOf(item)
            dataList.remove(item)
            notifyItemRemoved(pos)
        }


        bind.title.text=item.title
        bind.icon.setImageResource(item.icon)



    }


    class MViewHolder(val binding: RowOneItemBinding) : RecyclerView.ViewHolder(binding.root)
}