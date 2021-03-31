package com.ucoweb.tokoonline.activity


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import com.ucoweb.tokoonline.R
import com.ucoweb.tokoonline.helper.Helper
import com.ucoweb.tokoonline.model.Produk
import kotlinx.android.synthetic.main.activity_detailproduk.*
import kotlinx.android.synthetic.main.toolbar.*


class DetailProduk : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailproduk)

        getInfo()
    }

    fun getInfo(){
        val data = intent.getStringExtra("extra")
        val dataProduk =  Gson().fromJson<Produk>(data, Produk::class.java)


        //setValue
        tv_nama.text = dataProduk.name
        tv_harga.text= Helper().changeRp(dataProduk.harga)
        tv_deskripsi.text = dataProduk.deskripsi

        val img = "http://192.168.43.175/server_adm/public/storage/product/" + dataProduk.image
        Picasso.get()
            .load(img)
            .placeholder(R.drawable.erorr)
            .error(R.drawable.erorr)
            .resize(400, 400)
            .into(image)

        //setToolbar

        setSupportActionBar(toolbar)
        supportActionBar!!.title = dataProduk.name
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

}



