package com.comunidadedevspace.taskbeats.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.comunidadedevspace.taskbeats.R

class IntroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.intro_app)

        val btnContinuar: Button = findViewById(R.id.btnContinuar)


        btnContinuar.setOnClickListener{
            val intent = Intent (this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}