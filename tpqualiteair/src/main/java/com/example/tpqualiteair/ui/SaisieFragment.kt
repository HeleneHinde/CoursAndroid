package com.example.tpqualiteair.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.tpqualiteair.R
import com.example.tpqualiteair.bo.Ville
import com.example.tpqualiteair.databinding.ActivityMainBinding
import com.example.tpqualiteair.databinding.FragmentSaisieBinding

private const val TAG = "MainActivity"
class SaisieFragment : Fragment() {

    private val vm: VilleViewModel by viewModels { VilleViewModel.Factory }
    lateinit var binding: FragmentSaisieBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_saisie, container, false )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        binding.button.setOnClickListener {

            val ville = Ville(0, binding.etLieu.text.toString(),binding.ratingBar.rating)
            Log.i(TAG, "onViewCreated: "+ville)
           vm.addVille(ville).observe(this){

               Navigation.findNavController(view).navigate(R.id.saisie_to_affiche)
           }


        }

    }

}