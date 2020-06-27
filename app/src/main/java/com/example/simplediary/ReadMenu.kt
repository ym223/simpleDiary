package com.example.simplediary

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_read_menu.*

class ReadMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read_menu)

        happyBtn.setOnClickListener{
            val intent = Intent(this, HappyList::class.java)
            startActivity(intent)
        }

        sadBtn.setOnClickListener{
            val intent = Intent(this, SadList::class.java)
            startActivity(intent)
        }
    }
}