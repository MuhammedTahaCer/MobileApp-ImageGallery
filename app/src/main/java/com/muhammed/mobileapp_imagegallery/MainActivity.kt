package com.muhammed.mobileapp_imagegallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity() : AppCompatActivity() {
    var adapterCtg: Adapter?=null
    var list= ArrayList<Category>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val lvCategory=findViewById<ListView>(R.id.lvCategory)

        //listeye eleman:
        list.add(Category(1,"Flower","https://cdn.pixabay.com/photo/2015/04/19/08/32/marguerite-729510_960_720.jpg"))
        list.add(Category(2,"Nature","https://cdn.pixabay.com/photo/2023/04/25/15/08/church-7950418_960_720.jpg"))
        //list.add(Category(3,"Tech",""))
        //list.add(Category(4,"Healt",""))
        //list.add(Category(5,"Sport",""))
        list.add(Category(6,"Landscape","https://cdn.pixabay.com/photo/2023/04/25/18/14/mountain-7950729_960_720.jpg"))
        adapterCtg=Adapter(applicationContext,list)

        lvCategory.adapter = adapterCtg // //Adapter içine göndereceğimiz dosyaları MainActivity'e tanımlıyacağız
    }

    /*https://github.com/bumptech/glide
    * Glide kütüphanesi:
    * **Settings.gradle 'a mavenCentral() kodu eklenip sync edilir
    * **Build.gradle(Module) 'a implement kodu eklenir ve sync edilir. Artık Glide ile internetten veya cihaz üzerindeki herhangi contenti açmaya yarıyacak önbellek işlemleridir.*/

}