package com.jaffar.tpfirebase

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.GridView
import android.widget.Toast
import com.jaffar.tpfirebase.databinding.ActivityMainBinding
import com.jaffar.tpfirebase.databinding.ActivityModo1Binding

class Modo1 : AppCompatActivity() , AdapterView.OnItemClickListener {

    private var arrayList: ArrayList<Button>? = null
    private var gridAdapter: GridAdapter? = null

    private lateinit var bindModo1: ActivityModo1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindModo1 = ActivityModo1Binding.inflate(layoutInflater)
        setContentView(bindModo1.root)


        arrayList = ArrayList()
        arrayList = setData()
        gridAdapter = GridAdapter(applicationContext, arrayList!!)
        bindModo1.gridView?.adapter = gridAdapter
        bindModo1?.gridView.onItemClickListener = this
    }

    private fun setData(): ArrayList<Button> {
        var arrayList: ArrayList<Button> = ArrayList()

        for (i in 1..8) {
            for (i in 1..8) {
                arrayList.add(Button(this))
            }
        }
        return arrayList
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        var items: Button = arrayList!![position]
        items.setBackgroundColor(Color.parseColor("#ff2233"))
        items.text = "X"

    }

}