package com.example.tpvraifaux

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.tpvraifaux.bo.Question
import com.example.tpvraifaux.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val q1 = Question("Est-ce que la terre est plate ?", false)
        val q2 = Question("Est-ce que la lune est un astre", true)
        val q3 = Question("Est-ce que la terre tourne autour du soleil ?", true)

        val questions = arrayListOf<Question>(q1, q2, q3)

        var i = 0
        var y = questions.size
        var score = 0

        println(y)

        binding.question = questions[i]
        binding.tvScore.text = score.toString()

        binding.btnVrai.setOnClickListener {

            if (questions[i].reponse == true) {

                score++
                binding.tvScore.text = score.toString()

            }
            if (i < y - 1) {
                binding.question = questions[i + 1]
                i++
            } else {

                i = 0
                binding.question = questions[i]
            }


        }

        binding.btnFaux.setOnClickListener {

            if (questions[i].reponse == false) {

                score++
                binding.tvScore.text = score.toString()

            }
            if (i < y - 1) {
                binding.question = questions[i + 1]
                i++
            } else {

                i = 0
                binding.question = questions[i]
            }

        }

        binding.btnReset.setOnClickListener {
            i = 0
            binding.question = questions[i]
            score=0
            binding.tvScore.text = score.toString()
        }


    }
}