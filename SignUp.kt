package com.example.appdevalt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        /*sample lang*/
        val nameLayout: TextInputLayout = findViewById(R.id.name)
        val usernameLayout: TextInputLayout = findViewById(R.id.username)
        val passwordLayout: TextInputLayout = findViewById(R.id.password)
        val btnSignUp: Button = findViewById(R.id.btnSignUp)

        btnSignUp.setOnClickListener {
            val name: String = nameLayout.editText?.text.toString()
            val username: String = usernameLayout.editText?.text.toString()
            val password: String = passwordLayout.editText?.text.toString()

            val user: TextView = findViewById(R.id.tvfull)
            val un: TextView = findViewById(R.id.usertv)
            val pw: TextView = findViewById(R.id.passtv)

            user.text = "Name: $name"
            un.text = "Username: $username"
            pw.text = "Password: $password"
        }
    }

    fun toMainActivity(view: View) {
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)

    }

    fun toLogIn(view: View) {
        val i = Intent(this, LogIn::class.java)
        startActivity(i)
    }
}