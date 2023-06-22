package com.example.mod5navinterne

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.mod5navinterne.databinding.FragmentButtonBinding


class ButtonFragment : Fragment() {

lateinit var binding : FragmentButtonBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_button, container, false )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = view.findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val user = User("Camille", "Hervé")

            // ButtonFragmentDirections = class générée automatiquement grace au plugin
            // même chose pour actionButtonToEnd()
            val direction = ButtonFragmentDirections.actionButtonToEnd(User("Sylvain", "TROPEE"))
            Navigation.findNavController(view).navigate(direction)

            //Code pour passage d'un fragment à un autre sans data
            //Navigation.findNavController(view).navigate(R.id.action_button_toEnd)

        }

    }


}