package com.jaffar.tpfirebase

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.jaffar.tpfirebase.databinding.ActivityModo1Binding


class Modo1 : AppCompatActivity(){


    private lateinit var bindModo1: ActivityModo1Binding

    lateinit var gridView: GridView
    var pecasImages = ArrayList<Int>(64)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindModo1 = ActivityModo1Binding.inflate(layoutInflater)
        setContentView(bindModo1.root)


       for(i in 0 until 64){
           if(i == 27 || i == 36)
            pecasImages.add(R.drawable.x)
            else
           if(i == 28 || i == 35)
               pecasImages.add(R.drawable.y)
           else
               pecasImages.add(R.drawable.blank)
       }


        gridView = bindModo1.gridView



        val pecasAdapter = PecasAdapter(this,pecasImages)
        gridView.adapter = pecasAdapter

        gridView.onItemClickListener = AdapterView.OnItemClickListener { _, _, pos, _ ->
            pecasImages.set(27,R.drawable.x)
        }


    }


}