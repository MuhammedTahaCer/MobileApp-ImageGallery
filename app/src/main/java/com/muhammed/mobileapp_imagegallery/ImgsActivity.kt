package com.muhammed.mobileapp_imagegallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide

class ImgsActivity : AppCompatActivity() {

    var imglist=ArrayList<img>() //2. Kısım: img.kt dosyası ve komutları
    var sayi:Int=0//onlick eventlerinde hangi elemanı se.tiğimi gösterebilmek için bir değişken

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imgs)

        //3. kısım, componentleri tanımla
        val Galeri=findViewById<ImageView>(R.id.ivResim)
        val Basligi=findViewById<TextView>(R.id.twBaslik)
        val Geri=findViewById<Button>(R.id.btnGeri)
        val Rastgele=findViewById<Button>(R.id.btnRandom)
        val Sonraki=findViewById<Button>(R.id.btnSonraki)



        val baslik=intent.getStringExtra("Başlık")
        val kimliknum=intent.getIntExtra("Kategori Id", 0)

        this.setTitle(baslik)
        this.supportActionBar?.setDisplayHomeAsUpEnabled(true)//action bardaki geri butonu ekleme //bununla birlikte onOption metodu aşağıda oluşturulmuştur.

        //2. Kısım: img.kt dosyası ve komutları //Bir db olmadığı için bu şekilde yönetiyorum
        if(kimliknum==1){
            imglist.add(img(0,"",""))
            imglist.add(img(1,"",""))
            imglist.add(img(2,"",""))
        }else if(kimliknum==2){
            imglist.add(img(0,"",""))
            imglist.add(img(1,"",""))
            imglist.add(img(2,"",""))
        }else if(kimliknum==3){
            imglist.add(img(0,"",""))
            imglist.add(img(1,"",""))
            imglist.add(img(2,"",""))
        }else if(kimliknum==4){
            imglist.add(img(0,"",""))
            imglist.add(img(1,"",""))
            imglist.add(img(2,"",""))
        }else if(kimliknum==5){
            imglist.add(img(0,"",""))
            imglist.add(img(1,"",""))
            imglist.add(img(2,"",""))
        }else if(kimliknum==6){
            imglist.add(img(0,"",""))
            imglist.add(img(1,"",""))
            imglist.add(img(2,"",""))
        }


        //3. Kısım Buton Eventleri

        Glide.with(applicationContext).load(imglist.get(sayi).imgUrl).into(Galeri) //varsayılan olarak kategorinin ilk resmi gelicektir.
        Basligi.text=imglist.get(sayi).head

        Geri.setOnClickListener(View.OnClickListener{
            if (sayi>0){
                sayi--

            }else
            { Toast.makeText(applicationContext, "Lütfen Sonrakini Deneyin.", Toast.LENGTH_LONG).show() }
            Glide.with(applicationContext).load(imglist.get(sayi).imgUrl).into(Galeri)
            Basligi.text=imglist.get(sayi).head
        })
        Rastgele.setOnClickListener(View.OnClickListener{
            Glide.with(applicationContext).load(imglist.random().imgUrl).into(Galeri)
            Basligi.text=imglist.random().head
        })
        Sonraki.setOnClickListener(View.OnClickListener{
            if(sayi<imglist.size){
                sayi++
            }else{
                Toast.makeText(applicationContext, "Tüm Resimleri Gördünüz <3", Toast.LENGTH_SHORT).show() }
            Glide.with(applicationContext).load(imglist.get(sayi).imgUrl).into(Galeri)
            Basligi.text=imglist.get(sayi).head
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    //2. Kısım: Şimdi; resimleri listeleyebilmek için 'resim' isminde bir model sınıfı üretip; dolu const. seviyesinde, Arraylist'in içinden çağırma işlemini burada yapıcaz.

}