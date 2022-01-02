package com.jaffar.tpfirebase

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.get
import com.jaffar.tpfirebase.databinding.ActivityModo1Binding
import java.util.*
import kotlin.collections.ArrayList


class Modo1 : AppCompatActivity(){



    private  var vez:Int? = null
    private lateinit var bindModo1: ActivityModo1Binding
    lateinit var gridView: GridView
    var pecasImages = ArrayList<Int>(64)
    var pecasChars = ArrayList<Char>(64)

    lateinit var numJogadasPoss:ArrayList<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindModo1 = ActivityModo1Binding.inflate(layoutInflater)
        setContentView(bindModo1.root)


        var vez = (1..2).random()

        numJogadasPoss = ArrayList()

       for(i in 0 until 64){
           if(i == 27 || i == 36){
               pecasImages.add(R.drawable.x)

           } else if(i == 28 || i == 35){
               pecasImages.add(R.drawable.y)
           }
           else{
               pecasImages.add(R.drawable.blank)
           }

       }

        gridView = bindModo1.gridView

        val pecasAdapter = PecasAdapter(this,pecasImages)
        gridView.adapter = pecasAdapter

        gridView.onItemClickListener = AdapterView.OnItemClickListener { _, _, pos, _ ->


            verificaVizinhos(pecasImages, vez!!,numJogadasPoss)

            println(numJogadasPoss)
            println("size: " + numJogadasPoss.size)


            for (i in 0..numJogadasPoss.size){
                if(pos == i){
                    if(vez==1){
                        pecasImages.set(pos,R.drawable.x)
                        vez=2
                    }
                    else {
                        pecasImages.set(pos,R.drawable.y)
                        vez=1
                    }
                }
            }



            val pecasAdapter = PecasAdapter(this,pecasImages)
            gridView.adapter = pecasAdapter



        }


    }

    private fun verificaVizinhos(pecasImages: ArrayList<Int>, vez: Int, numJogadasPoss: ArrayList<Int>) {

        var peca:Int
        var temp: Int

        if(vez == 1){
            peca = R.drawable.y
            temp = R.drawable.y
        }
        else{
            temp = R.drawable.x
            peca = R.drawable.x
        }




        for(i in 0..63){
            if(pecasImages[i] == temp){
                if(pecasImages[i+1] == peca) verificavizinhos2(i+1,pecasImages,temp,numJogadasPoss)
                if(pecasImages[i-1] == peca) verificavizinhos2(i-1,pecasImages,temp,numJogadasPoss)
                if(pecasImages[i+8] == peca) verificavizinhos2(i+8,pecasImages,temp,numJogadasPoss)
                if(pecasImages[i-8] == peca) verificavizinhos2(i-8,pecasImages,temp,numJogadasPoss)
                if(pecasImages[i+9] == peca) verificavizinhos2(i+9,pecasImages,temp,numJogadasPoss)
                if(pecasImages[i-9] == peca) verificavizinhos2(i-9,pecasImages,temp,numJogadasPoss)
                if(pecasImages[i+7] == peca) verificavizinhos2(i+7,pecasImages,temp,numJogadasPoss)
                if(pecasImages[i-7] == peca) verificavizinhos2(i-7,pecasImages,temp,numJogadasPoss)
            }
        }

    }

    private fun verificavizinhos2(i: Int, pecasImages: ArrayList<Int>, vez: Int, numJogadasPoss: ArrayList<Int>) {

        numJogadasPoss.clear()
        if(pecasImages[i+1] == vez) numJogadasPoss.add(i-1)
        if(pecasImages[i-1] == vez) numJogadasPoss.add(i-1)
        if(pecasImages[i+8] == vez) numJogadasPoss.add(i-1)
        if(pecasImages[i-8] == vez) numJogadasPoss.add(i-1)
        if(pecasImages[i+9] == vez) numJogadasPoss.add(i-1)
        if(pecasImages[i-9] == vez) numJogadasPoss.add(i-1)
        if(pecasImages[i+7] == vez) numJogadasPoss.add(i-1)
        if(pecasImages[i-7] == vez) numJogadasPoss.add(i-1)
    }


}