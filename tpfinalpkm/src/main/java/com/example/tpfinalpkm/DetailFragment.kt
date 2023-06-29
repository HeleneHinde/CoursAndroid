package com.example.tpfinalpkm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.tpfinalpkm.bo.Pokemon
import com.example.tpfinalpkm.databinding.FragmentDetailBinding
import com.squareup.picasso.Picasso


class DetailFragment : Fragment() {

    val args : DetailFragmentArgs by navArgs()
    lateinit var binding : FragmentDetailBinding
    private val vm : PokemonViewModel by viewModels { PokemonViewModel.Factory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_detail, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvNom.text=args.pkm.nom
        Picasso.get()
            .load(args.pkm.image)
            .into(binding.imageView)

        binding.button.setOnClickListener{

            var pokemon = args.pkm

            vm.addPokemon(pokemon)

            vm.pokemon.observe(this){
                Toast.makeText(view.context,"le pokémon " +it.nom + " a été ajouté", Toast.LENGTH_LONG).show()

            }
        }

    }

}