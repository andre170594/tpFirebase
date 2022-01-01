package com.jaffar.tpfirebase

import android.content.Context
import android.graphics.Color
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ImageView
import com.jaffar.tpfirebase.R.layout.grid_item
import com.jaffar.tpfirebase.model.Item
import android.view.LayoutInflater as LayoutInflater1

class GridAdapter(var context: Context,var arrayList: ArrayList<Item>) : BaseAdapter() {

    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(p0: Int): Any {
        return arrayList[p0]
    }

    override fun getItemId(p0: Int): Long {
       return p0.toLong()
    }

    override fun getView(pos: Int, convertView: View?, parent: ViewGroup?): View {
        var view:View = View.inflate(context,R.layout.grid_item, null)

        var item:ImageView = view.findViewById(R.id.imgView)
        var listItems: Item = arrayList[pos]

        item.setPadding(1,1,1,1)

        return view
    }


}