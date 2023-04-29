package com.muhammed.mobileapp_imagegallery

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class Adapter:BaseAdapter {

    private  var layoutInflater:LayoutInflater?=null
    private  var context:Context?=null
    private  var categories:ArrayList<Category>?=null

    constructor(){

    }
    constructor(context: Context,categories:ArrayList<Category>?){
        this.context=context
        this.categories=categories
        this.layoutInflater=context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getCount(): Int {
        return categories!!.size
    }

    override fun getItem(position: Int): Any {
        return categories!![position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view=layoutInflater.inflate(R.layout.categorylineview, null)
        val twHead=view.findViewById<TextView>(R.id.twCategory)
        twHead.text=categories!![position].head
        return view
    }
}