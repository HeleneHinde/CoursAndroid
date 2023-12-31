package com.example.tpcolor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation

class ShortButtonFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_short_button, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = view.findViewById<Button>(R.id.buttonShort)

        button.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_shortButtonFragment_to_shortButtonGreenFragment)

        }

        button.setOnLongClickListener {
            Navigation.findNavController(view).navigate(R.id.action_shortButtonFragment_to_shortButtonRedFragment)
            true
        }

    }
}