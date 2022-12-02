package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SignUpActivity : AppCompatActivity() {
    lateinit var fname: EditText
    lateinit var lname: EditText
    lateinit var age: EditText
    lateinit var emailAddress: EditText
    lateinit var password: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        fname = findViewById(R.id.firstName)
        lname = findViewById(R.id.lastName)
        age = findViewById(R.id.age)
        emailAddress = findViewById(R.id.signupEmailAddress)
        password = findViewById(R.id.signupPassword)



    }


    fun signupClicked(view: View){
        println(fname.text.toString())
        val acc = UserAccount.signup(fname.text.toString(), lname.text.toString(), age.text.toString().toInt(), emailAddress.text.toString(), password.text.toString())

    }





}
class UserAccount(val firstName: String, val lastName: String, val age: Int, val email: String, val password: String){


    companion object{
        var userEmails = mutableListOf<String>();

        fun signup(firstName: String, lastName: String, age: Int, email: String, password: String): UserAccount?{

            var numErrors: Int = 0

            if (password.length < 10){
                println("Error: less than 10 characters")
                numErrors += 1
            }

            if (age < 16){
                println("Error: age is less than 16")
                numErrors += 1
            }

            if (firstName.length <= 0 || lastName.length <= 0){
                println("Error: Invalid first or last name")
                numErrors += 1
            }

            if (userEmails.contains(email) == true){
                println("Error: email is already registered")
                numErrors += 1
            }

            if (email.length <= 0){
                println("invalid email")
                numErrors += 1
            }

            if (numErrors == 0){
                userEmails.add(email)
                return UserAccount(firstName, lastName, age, email, password)
            }

            return null
        }
    }
}
