package com.project.discretaii_project.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.project.discretaii_project.R
import kotlinx.android.synthetic.main.activity_game.*


class Game : AppCompatActivity() {

    var questions = listOf(R.string.q1,R.string.q2,R.string.q3,R.string.q4,R.string.q5,R.string.q6)

    private var counter = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        showQuestion()
        bt_next.setOnClickListener{
            //nextquestion(2)

            id_question.text = getString(questions[counter])
            counter ++
        }
    }

    fun showQuestion(){

        id_question.text = getString(R.string.q1)
    }

    private fun nextquestion(i: Int): Int{
        return when (i) {
            1 -> {
                counter--
                if(counter<0) counter = 2
                questions[counter]
            }
            else -> {
                counter++
                if(counter>2) counter = 0
                questions[counter]
            }
        }
    }
}
