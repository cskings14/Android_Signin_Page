package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    lateinit var editTextPword: EditText
    lateinit var editTextEmail: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextEmail = findViewById(R.id.email)
        editTextPword = findViewById(R.id.pword)


    }



    fun enterInfo(view: View) {

        if (editTextEmail.text.toString() == "correct" && editTextPword.text.toString() == "password"){
            println("Login complete")
        }
    }

    fun signup(view: View){
        println("button tapped")
        val intent = Intent(this, SignUpActivity::class.java)

        startActivity(intent)

    }





}


