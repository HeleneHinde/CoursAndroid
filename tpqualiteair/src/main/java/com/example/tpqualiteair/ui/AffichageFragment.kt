package com.example.tpqualiteair.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.tpqualiteair.R
import com.example.tpqualiteair.bo.Ville
import com.example.tpqualiteair.databinding.FragmentAffichageBinding
import com.example.tpqualiteair.databinding.FragmentSaisieBinding

private const val TAG = "AffichageFragment"

class AffichageFragment : Fragment() {

    private val vm: VilleViewModel by viewModels { VilleViewModel.Factory }
    lateinit var binding: FragmentAffichageBinding

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



        binding.btnLog.setOnClickListener {

            vm.getAll()

            vm.villes.observe(this){
               Log.i(TAG, "onViewCreated: "+it.toString())
/*                it.forEach{

                    Log.i(TAG, "onViewCreated: "+it.toString())
                }*/

            }

        }

    }


}