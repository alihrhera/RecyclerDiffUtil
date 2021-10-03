package com.taskapp.recyclerdiffutil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.taskapp.recyclerdiffutil.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater, null, false)
        setContentView(binding.root)


        val list = mutableListOf<Item>()

        binding.dataRecyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = AdapterRecyclerDiffUtil()

        binding.dataRecyclerView.adapter = adapter

        for (i in 0..10) {
            list.add(
                Item(
                    i,
                    "This is test text for android app text $i for item $i set as item title $i ",
                    if (i%2==0){R.drawable.ic_baseline_adb_24}else{R.drawable.ic_baseline_architecture_24}
                )
            )
        }

        adapter.setDataList(list)


    }

}