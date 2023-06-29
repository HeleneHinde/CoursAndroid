package com.example.tpfinalpkm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.tpfinalpkm.bo.Pokemon
import com.example.tpfinalpkm.databinding.TemplatePkmLineBinding
import com.squareup.picasso.Picasso

class PokemonAdapter(val listPokemon: List<Pokemon>, val listener : (pokemon:Pokemon)->Unit):Adapter<PokemonAdapter.PokemonVH>() {


    class PokemonVH(val binding : TemplatePkmLineBinding): ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonVH {
        val binding=TemplatePkmLineBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PokemonVH(binding)
    }

    override fun getItemCount(): Int {
        return listPokemon.size
    }

    override fun onBindViewHolder(holder: PokemonVH, position: Int) {
        holder.binding.pkm=listPokemon[position]

        Picasso.get()
            .load(listPokemon[position].image)
            .into(holder.binding.imageView2)

        holder.itemView.setOnClickListener {
            listener.invoke(listPokemon[position])
        }

    }
}