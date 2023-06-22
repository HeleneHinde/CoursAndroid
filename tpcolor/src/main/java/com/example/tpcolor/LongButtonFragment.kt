package com.example.tpcolor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation


class LongButtonFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_long_button, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = view.findViewById<Button>(R.id.buttonLong)

        button.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_longButtonFragment_to_longButtonYellowFragment)

        }

        button.setOnLongClickListener {
            Navigation.findNavController(view).navigate(R.id.action_longButtonFragment_to_longButtonBlueFragment)
            true
        }

    }
}