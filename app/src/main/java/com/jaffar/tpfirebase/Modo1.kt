package com.jaffar.tpfirebase

import android.graphics.Color
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.get
import com.jaffar.tpfirebase.databinding.ActivityModo1Binding
import com.jaffar.tpfirebase.model.Item





class Modo1 : AppCompatActivity(), AdapterView.OnItemClickListener{


    private var arrayList: ArrayList<Item>? = null
    private var gridView: GridView ? = null
    private var gridAdapter:GridAdapter ? = null

    private lateinit var bindModo1: ActivityModo1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindModo1 = ActivityModo1Binding.inflate(layoutInflater)
        setContentView(bindModo1.root)

        arrayList = ArrayList()
        arrayList = setData()
        gridAdapter = GridAdapter(applicationContext,arrayList!!)
        bindModo1.gridView?.adapter = gridAdapter
        bindModo1.gridView?.onItemClickListener = this

    }


    private fun setData():ArrayList<Item>{
        var arrayList: ArrayList<Item> = ArrayList()

        for (i in 1..8) {
            for (i in 1..8) {
                arrayList.add(Item(ImageView(this)))
            }
        }

        return arrayList
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        arrayList!![position].image!!.apply { setBackgroundColor(Color.parseColor("#7f66ff")) }

       parent!![position].setBackgroundColor(Color.parseColor("#7f66ff"))

    }

}