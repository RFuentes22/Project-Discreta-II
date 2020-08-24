package com.project.discretaii_project.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.marcinmoskala.math.factorial
import com.project.discretaii_project.R
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var intent: Intent

        btn_play.setOnClickListener {
             intent = Intent(this, Game::class.java)
            startActivity(intent)
        }

        about_btn.setOnClickListener {
            intent = Intent(this, About::class.java)
            startActivity(intent)
        }
    }
}
