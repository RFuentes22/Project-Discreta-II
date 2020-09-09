package com.project.discretaii_project.Activities

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.marcinmoskala.math.factorial
import com.marcinmoskala.math.pow
import com.project.discretaii_project.R
import kotlinx.android.synthetic.main.activity_game.*
import kotlin.system.exitProcess


class Game : AppCompatActivity() {

    var questions =
        listOf(R.string.q1, R.string.q2, R.string.q3, R.string.q4, R.string.q5, R.string.q6)
    var buenas = 0
    var malas = 0


    private var counter = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        id_question.text = getString(R.string.q1)

        bt_next.setOnClickListener {
            if (validatempty()) {
                if (validar(counter)) {
                    buenas++
                    Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show()
                } else {
                    malas++
                    Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show()
                }

                Log.d("buenas", buenas.toString())
                et_x.text.clear()
                et_answer.text.clear()
                nextQuestion()

            }

        }
    }

    fun validatempty(): Boolean {
        if (counter == 5){
            if (et_answer.text.isEmpty()) {
                et_answer!!.error = "Introduce la respuesta"
                return false
            }
        }
        else {
            if (et_x.text.isEmpty()) {
                et_x!!.error = "Introduce X"
                return false
            }
            if (et_answer.text.isEmpty()) {
                et_answer!!.error = "Introduce la respuesta"
                return false
            }
        }

        return true
    }


    fun nextQuestion() {
        if (counter == 6) {
            val intent = Intent(this, result::class.java)
            intent.putExtra("buenas", buenas.toString())
            intent.putExtra("malas", malas.toString())
            startActivity(intent)
        } else {

            id_question.text = getString(questions[counter])
            counter++
        }

    }

    fun validar(id: Int): Boolean {
        val r: Int
        val x: Int = if (counter == 5){
            0
        } else et_x.text.toString().toInt()
        return when (id) {
            1 -> {
                r = (et_x.text.toString().toInt()).pow(3)
                // Log.d("r",r.toString())
                // Log.d("myresult",et_answer.text.toString())
                r == et_answer.text.toString().toInt()
            }

            2 -> {
                r = (et_x.text.toString().toInt() - 1).factorial().toInt()
                Log.d("re", r.toString())
                Log.d("myresult", et_answer.text.toString())
                r == et_answer.text.toString().toLong().toInt()
            }

            3 -> {
                r = (6.factorial() / (x.factorial() * (6 - x).factorial())).toInt()
                r == et_answer.text.toString().toInt()
            }

            4 -> {
                r = (x.factorial() / (5.factorial() * (x - 5).factorial())).toInt()
                tv_nameTeamA.isEnabled = false;
                et_x.isEnabled = false
                r == et_answer.text.toString().toInt()

            }

            5 -> {

                //  r = (x.factorial()/ (3.factorial()*4.factorial()*2.factorial()) ).toInt()
                tv_nameTeamA.isEnabled = true
                et_x.isEnabled = true
                Log.d("res 5", x.toString())
                et_answer.text.toString().toInt() == 26

            }

            6 -> {
                r = (x.factorial() / ((x - 2).factorial())).toInt()
                r == et_answer.text.toString().toInt()
            }

            else -> false
        }
    }

    private fun disableEditText(editText: EditText) {
        editText.isFocusable = false
        editText.isEnabled = false
        editText.isCursorVisible = false
        editText.keyListener = null
        editText.setBackgroundColor(Color.TRANSPARENT)
    }


}
