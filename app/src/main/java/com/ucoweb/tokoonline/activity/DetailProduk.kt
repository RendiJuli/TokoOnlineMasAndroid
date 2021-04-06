package com.ucoweb.tokoonline.activity


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import com.ucoweb.tokoonline.R
import com.ucoweb.tokoonline.dao.MyDatabase
import com.ucoweb.tokoonline.helper.Helper
import com.ucoweb.tokoonline.model.Produk
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_detailproduk.*
import kotlinx.android.synthetic.main.activity_detailproduk.tv_nama
import kotlinx.android.synthetic.main.toolbar.*


class DetailProduk : AppCompatActivity() {

    lateinit var dataProduk: Produk

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailproduk)


        getInfo()
        mainButton()

    }


    fun mainButton(){
        btn_keranjangProduk.setOnClickListener {
            insert()
        }

        btn_fav.setOnClickListener {
            val myDb: MyDatabase = MyDatabase.getInstance(this)!! // call database
            val listData = myDb.daoKeranjang().getAll() // get All data
            for(note : Produk in listData){
                println("-----------------------")
                println(note.name)
                println(note.harga)
            }
        }

    }

    fun insert(){
        val myDb: MyDatabase = MyDatabase.getInstance(this)!! // call database
        CompositeDisposable().add(Observable.fromCallable { myDb.daoKeranjang().insert(dataProduk) }
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.d("respons", "data inserted")
            })
    }

    fun getInfo(){
        val data = intent.getStringExtra("extra")
        dataProduk =  Gson().fromJson<Produk>(data, Produk::class.java)


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



