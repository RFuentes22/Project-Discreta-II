package com.project.discretaii_project.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.marcinmoskala.math.factorial
import com.marcinmoskala.math.pow
import com.project.discretaii_project.R
import kotlinx.android.synthetic.main.activity_game.*


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
        if (et_x.text.isEmpty()) {
            et_x!!.error = "Introduce X"
            return false
        }
        if (et_answer.text.isEmpty()) {
            et_answer!!.error = "Introduce la respuesta"
            return false
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
        val x = et_x.text.toString().toInt()
        return when (id) {
            1 -> {
                r = (et_x.text.toString().toInt()).pow(3)
                // Log.d("r",r.toString())
                // Log.d("myresult",et_answer.text.toString())
                if (r == et_answer.text.toString().toInt()) {

                    true
                } else {
                    false
                }
            }

            2 -> {
                r = (et_x.text.toString().toInt()-1).factorial().toInt()
                Log.d("re", r.toString())
                Log.d("myresult", et_answer.text.toString())
                if (r == et_answer.text.toString().toLong().toInt()) {
                    true
                } else {
                    false
                }
            }

            3 -> {
                r = (6.factorial() / (x.factorial() * (6 - x).factorial())).toInt()
                if (r == et_answer.text.toString().toInt()) {
                    true
                } else {
                    false
                }
            }

            4 -> {
                r = (x.factorial() / (5.factorial() * (x - 5).factorial())).toInt()
                if (r == et_answer.text.toString().toInt()) {
                    true
                } else {
                    false
                }
            }

            5 -> {
                r = (x.factorial()/ (3.factorial()*4.factorial()*2.factorial()) ).toInt()
                Log.d("res",r.toString())
                if (r == et_answer.text.toString().toInt()) {
                    true
                } else {
                    false
                }
            }

            6 -> {
                r = (x.factorial() / ((x - 2).factorial())).toInt()
                if (r == et_answer.text.toString().toInt()) {
                    true
                } else {
                    false
                }
            }

            else -> false
        }
    }


}
