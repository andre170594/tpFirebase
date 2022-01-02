package com.jaffar.tpfirebase

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListAdapter

class PecasAdapter(private val context: Context, private val pecas:ArrayList<Int>) : BaseAdapter() {


    private var layoutInflater: LayoutInflater? = null
    private lateinit var imageView: ImageView


    override fun getCount(): Int {
        return pecas.size
    }

    override fun getItem(p0: Int): Any? {
        return null
    }

    override fun getItemId(p0: Int): Long {
        return  0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var convertView = convertView;
        if(layoutInflater == null)
            layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        if(convertView == null)
            convertView = layoutInflater!!.inflate(R.layout.rowitem,null)
        imageView=convertView!!.findViewById(R.id.imageView)
        imageView.setImageResource(pecas[position])
        return convertView

    }


}
