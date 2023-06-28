package com.example.mod10recycleview.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.mod10recycleview.bo.Cat
import com.example.mod10recycleview.databinding.TemplatesCatLineBinding

class CatAdapter(val listCat : ArrayList<Cat>, val listener : (cat:Cat)->Unit): Adapter<CatAdapter.CatVH>() {

    class CatVH(val binding : TemplatesCatLineBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatVH {
        val binding = TemplatesCatLineBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CatVH(binding)
    }

    override fun getItemCount(): Int {
        return listCat.size
    }

    override fun onBindViewHolder(holder: CatVH, position: Int) {
        holder.binding.cat = listCat[position]
        holder.itemView.setOnClickListener{
            listener.invoke(listCat[position])
        }


    }


}