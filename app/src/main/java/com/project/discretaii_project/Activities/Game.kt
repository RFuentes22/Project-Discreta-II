package com.project.discretaii_project.Activities

import android.content.Intent
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

        id_question.text = getString(R.string.q1)

        bt_next.setOnClickListener{
            nextQuestion()
        }
    }

    fun nextQuestion(){
        if(counter==6){
            val intent = Intent(this, result::class.java)
            startActivity(intent)
        }
        else {
            id_question.text = getString(questions[counter])
            counter++
        }

    }



}
