package com.example.passnotelite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       passmanager.setOnClickListener {
        startActivity(Intent(this,PasswordManager::class.java))
       }
        notesmanager.setOnClickListener {
         startActivity(Intent(this,NotesManager::class.java))
        }
    }
}