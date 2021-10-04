package com.example.moofwd_app.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moofwd_app.R
import com.example.moofwd_app.SecondFragment
import com.example.moofwd_app.databinding.ItemListBinding
import com.example.moofwd_app.entities.ItemEnti


class ItemAdapter(private val context: Context): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    private var items = mutableListOf<ItemEnti>()


    fun updateListItem(data: MutableList<ItemEnti>){
        items = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemListBinding.inflate(inflater, parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemAdapter.ItemViewHolder, position: Int) {
        holder.bind(items[position])
    }



    override fun getItemCount()  = items.size

    inner class ItemViewHolder(val binding: ItemListBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(item: ItemEnti) = with(itemView){
            binding.txtTitle.text = item.title
            binding.txtDesc.text = item.desc
            binding.txtDate.text = item.date
            Glide.with(itemView.context).load(item.image).centerCrop().into(binding.imageView2)


            itemView.setOnClickListener {

            }
        }
    }





}

//