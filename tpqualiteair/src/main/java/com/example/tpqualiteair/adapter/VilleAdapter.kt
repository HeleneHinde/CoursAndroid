package com.example.tpqualiteair.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.tpqualiteair.bo.Ville
import com.example.tpqualiteair.databinding.TemplateVilleLineBinding

class VilleAdapter(val listVille : List<Ville>): Adapter<VilleAdapter.VilleVH>() {

    class VilleVH(val binding : TemplateVilleLineBinding):ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VilleVH {
        val binding=TemplateVilleLineBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return VilleVH(binding)
    }

    override fun getItemCount(): Int {
        return listVille.size
    }

    override fun onBindViewHolder(holder: VilleVH, position: Int) {
        holder.binding.ville=listVille[position]



    }

}