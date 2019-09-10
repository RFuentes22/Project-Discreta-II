package com.project.discretaii_project.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.project.discretaii_project.R
import kotlinx.android.synthetic.main.activity_result.*


class result : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        val buenas = intent.getStringExtra("buenas")
        val malas = intent.getStringExtra("malas")

        correct_ans.text = buenas
        wrong_ans.text = malas

        btn_retry.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }
    override fun onBackPressed() {}
}
