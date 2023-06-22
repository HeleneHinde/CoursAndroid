package com.example.tphistoire

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.tphistoire.databinding.FragmentQuestionnaireBinding


class QuestionnaireFragment : Fragment() {

lateinit var binding: FragmentQuestionnaireBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding=DataBindingUtil.inflate(inflater, R.layout.fragment_questionnaire,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener {


            val histoire  = Histoire(binding.etPrenom.text.toString(),binding.etLieu.text.toString())
            val direction = QuestionnaireFragmentDirections.questionToHistoire(histoire)
            Navigation.findNavController(view).navigate(direction)
        }

    }


}