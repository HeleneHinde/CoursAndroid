package com.example.tpvraifaux

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.tpvraifaux.bo.Question
import com.example.tpvraifaux.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding

    val q1 = Question("Est-ce que la terre est plate ?", false)
    val q2 = Question("Est-ce que la lune est un astre", true)
    val q3 = Question("Est-ce que la terre tourne autour du soleil ?", true)

    val questions = arrayListOf<Question>(q1, q2, q3)

    var i = 0
    var y = questions.size
    var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        binding.question = questions[i]
        binding.tvScore.text = score.toString()

        binding.btnVrai.setOnClickListener {

            onClickEvent(true)

        }

        binding.btnFaux.setOnClickListener {

            onClickEvent(false)

        }

        binding.btnReset.setOnClickListener {
            i = 0
            binding.question = questions[i]
            score = 0
            binding.tvScore.text = score.toString()
            binding.btnFaux.isEnabled = true
            binding.btnVrai.isEnabled = true
        }


    }
    fun onClickEvent(button: Boolean) {

        if (questions[i].reponse == button) {
            score++
            binding.tvScore.text = score.toString()

        }
        i++
        if (i < y) {
            binding.question = questions[i]

        } else {


            binding.tvQuestion.text="Terminé ! Votre score est de : "+score
            binding.btnFaux.isEnabled = false
            binding.btnVrai.isEnabled = false

        //code pour retour à 0
        /*  i = 0
            binding.question = questions[i]*/
        }
    }
}
