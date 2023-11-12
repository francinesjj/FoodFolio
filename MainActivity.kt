package com.example.appdevalt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
 



    }

    // to Sign Up
    fun toSignUp(view: View) {
        val i = Intent(this, SignUp::class.java)
        startActivity(i)
    }

    //to Log In
    fun toLogIn(view: View) {
        val i = Intent(this, LogIn::class.java)
        startActivity(i)
    }
}