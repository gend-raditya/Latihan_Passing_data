package com.example.latihanhariselasa

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var etUsernameLogin : EditText
    private lateinit var etPasswordLogin : EditText
    private lateinit var btnLoginPage : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        etUsernameLogin = findViewById(R.id.etUsernameLogin)
        etPasswordLogin = findViewById(R.id.etPasswordLogin)
        btnLoginPage = findViewById(R.id.btnLoginPage)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnLoginPage.setOnClickListener() {
            var intent = Intent(this@MainActivity, Welcome_Page::class.java)
            val nUsername = etUsernameLogin.text.toString()
            val nPassword = etPasswordLogin.text.toString()
            intent.putExtra("username", nUsername)
            intent.putExtra("password", nPassword)

            // cek data yang sudah dikirim
            Log.d("username nya : ", nUsername)
            Log.d("Password nya : ", nPassword)
            startActivity(intent)
        }

    }
}