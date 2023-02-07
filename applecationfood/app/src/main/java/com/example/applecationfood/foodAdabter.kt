package com.example.applecationfood

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.applecationfood.databinding.FooooodBinding
import food

class foodAdabter: ListAdapter<food, RecyclerView.ViewHolder>(DIFF_CALLBACK) {
    var x=SharedPref
    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<food>() {

            override fun areItemsTheSame(oldItem: food, newItem: food): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: food, newItem: food): Boolean {
                return oldItem.name == newItem.name && oldItem.imageUrl == newItem.imageUrl
            }

        }
    }

    private lateinit var binding: FooooodBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            RecyclerView.ViewHolder {
        binding = FooooodBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolder){
            val item = getItem(position)
            holder.bind(item)
        }
    }

    inner class ViewHolder(val itemBinding: FooooodBinding):
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: food){
            val setting=SharedPref(itemBinding.namefood.context)
            itemBinding.namefood.text = item.name
            itemBinding.namefood.textSize = setting.getFontSize().toFloat()
            itemBinding.namefood.setOnClickListener {
                Toast.makeText(it.context,"name: ${item.name}", Toast.LENGTH_LONG).show()
            }
            itemBinding.photofood.setImageResource(item.imageUrl)

        }

    }

}