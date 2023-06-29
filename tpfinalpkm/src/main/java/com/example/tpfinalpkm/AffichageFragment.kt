package com.example.tpfinalpkm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tpfinalpkm.adapter.PokemonAdapter
import com.example.tpfinalpkm.bo.Pokemon
import com.example.tpfinalpkm.databinding.FragmentAffichageBinding


class AffichageFragment : Fragment() {

    private val vm : PokemonViewModel by viewModels { PokemonViewModel.Factory }
    lateinit var binding : FragmentAffichageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_affichage, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = binding.recycler

        vm.getAll()

        vm.listPokemon.observe(this){

            recycler.adapter=PokemonAdapter(it){
                val direction = AffichageFragmentDirections.listToDetail(it)
                Navigation.findNavController(view).navigate(direction)
            }
            recycler.layoutManager = LinearLayoutManager(view.context)

        }


    }

}