package com.muhammed.mobileapp_imagegallery

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class Adapter:BaseAdapter {

    private var layoutInflater:LayoutInflater?=null
    private var context:Context?=null
    private var categories:ArrayList<Category>?=null

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
        val v= layoutInflater!!.inflate(R.layout.categorylineview, null)
        val twHead= v.findViewById<TextView>(R.id.twCategory)
        //Glide ekledikten sonra
            val ivImages=v.findViewById<ImageView>(R.id.imgCategory)
            //glide usages exm : Glide.with(this).load("https://goo.gl/gEgYUd").into(imageView);
            Glide.with(v.context).load(categories!![position].imgUrl).into(ivImages);//Activity sınıfı içinde olmadığımız için this ifadesini kabul etmiyor. O halde konumunu tvermeli
        //Glide ekledikten sonra
        twHead!!.text=categories!![position].head
        return v


        v.setOnClickListener{
            val intent=Intent(v.context,ImgsActivity::class.java)
            intent.putExtra("başlık", categories!!.get(position).head) //diğer activitye intent ile data taşıma(putExtra komutu)
            intent.putExtra("Kategori ID",categories!!.get(position).id)//diğer activitye intent ile data taşıma(putExtra komutu)
            //startActivity içinde intenti gönderebiliriz artık. Ancak burası bir startact. değil.  o halde:
            v.context.startActivity(intent)
        }
    }
}