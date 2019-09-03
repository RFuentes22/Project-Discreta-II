package com.project.discretaii_project.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.project.discretaii_project.R
import kotlinx.android.synthetic.main.activity_game.*

class Game : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        showQuestion()
    }

    fun showQuestion(){
        var questions = listOf("Suponiendo que hay X letras distintas. ¿Cuantos conjuntos diferentes de iniciales pueden formarse si cada persona " +
                "tiene un apellido y exactamente dos nombres?", "Hola","Mundo")

        id_question.text = questions[0]
    }
}
