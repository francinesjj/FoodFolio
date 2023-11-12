package com.example.appdevalt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.appdevalt.ui.home.HomeFragment
import com.google.android.material.textfield.TextInputLayout

class LogIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        val user: TextInputLayout = findViewById(R.id.user)
        val pass: TextInputLayout = findViewById(R.id.password)
        val btnLogIn: Button = findViewById(R.id.btnLogIn)
        val tvUsername: TextView = findViewById(R.id.tv)
        val tvPassword: TextView = findViewById(R.id.tvpassword)

        btnLogIn.setOnClickListener {
            /*sample lang*/
            val username: String = user.editText?.text.toString()
            val password: String = pass.editText?.text.toString()

            tvUsername.text = "Username: $username"
            tvPassword.text = "Password: $password"

            val i = Intent(this, HomeFragment::class.java)
            startActivity(i)

        }
    }

    fun toMainActivity(view: View) {
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }

    fun toSignUp(view: View) {
        val i = Intent(this, SignUp::class.java)
        startActivity(i)
    }
}