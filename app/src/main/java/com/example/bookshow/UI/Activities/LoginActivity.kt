package com.example.bookshow.UI.Activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bookshow.R

class LoginActivity : AppCompatActivity() {

    lateinit var userNameET : EditText
    lateinit var passwordET : EditText
    lateinit var signinBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        userNameET = findViewById(R.id.username_et)
        passwordET = findViewById(R.id.password_et)
        signinBtn = findViewById(R.id.signinBtn)

        signinBtn.setOnClickListener{

            val userName = userNameET.text.toString()
            val password = passwordET.text.toString()

            if (userName.isNotEmpty() && password.isNotEmpty()) {

                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
                finish()

            } else if (userName.isEmpty()) {
                Toast.makeText(this , "Please enter user name",Toast.LENGTH_SHORT).show()
            } else if (password.isEmpty()) {
                Toast.makeText(this , "Please enter password",Toast.LENGTH_SHORT).show()
            }

        }

    }
}