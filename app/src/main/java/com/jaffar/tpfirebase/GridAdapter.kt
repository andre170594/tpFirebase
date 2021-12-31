package com.jaffar.tpfirebase

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import com.jaffar.tpfirebase.R.layout.grid_item

class GridAdapter(var context:Context,var grelha: ArrayList<Button>) : BaseAdapter() {
    override fun getCount(): Int {
        return grelha.size
    }

    override fun getItem(pos: Int): Any {
       return grelha[pos]
    }

    override fun getItemId(pos: Int): Long {
        return pos.toLong()
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return View.inflate(context, grid_item, null)
    }


}