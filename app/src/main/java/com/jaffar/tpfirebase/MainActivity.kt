package com.jaffar.tpfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jaffar.tpfirebase.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var bindMain: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindMain.root)



        bindMain.btnModo1.setOnClickListener {
            val intent = Intent(this, Modo1::class.java)
            startActivity(intent)
            finish()
        }



    }
}