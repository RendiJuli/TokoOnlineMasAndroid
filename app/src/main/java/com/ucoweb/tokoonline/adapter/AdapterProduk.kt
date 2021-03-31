package com.ucoweb.tokoonline.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import com.ucoweb.tokoonline.MainActivity
import com.ucoweb.tokoonline.R
import com.ucoweb.tokoonline.activity.DetailProduk
import com.ucoweb.tokoonline.activity.Login
import com.ucoweb.tokoonline.helper.Helper
import com.ucoweb.tokoonline.model.Produk
import java.text.NumberFormat
import java.util.*

class AdapterProduk(var activity: Activity, var data:ArrayList<Produk>): RecyclerView.Adapter<AdapterProduk.Holder>() {

    class Holder(view: View): RecyclerView.ViewHolder(view) {
        val tvNama = view.findViewById<TextView>(R.id.tv_nama)
        val tvHarga = view.findViewById<TextView>(R.id.tv_harga)
        val imgProduk = view.findViewById<ImageView>(R.id.img_produk)
        val layout= view.findViewById<CardView>(R.id.layout_item)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_produk, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.tvNama.text = data[position].name //GET from APIService
        holder.tvHarga.text = Helper().changeRp(data[position].harga)
       // holder.imgProduk.setImageResource(data[position].image)

        val image = "http://192.168.43.175/server_adm/public/storage/product/" + data[position].image
        Picasso.get()
            .load(  image)
            .placeholder(R.drawable.erorr)
            .error(R.drawable.erorr)
            .into(holder.imgProduk)

        holder.layout.setOnClickListener {

        val intent = Intent(activity, DetailProduk::class.java) //ke class detailproduk

            val str =  Gson().toJson(data[position], Produk::class.java)

            intent.putExtra("extra", str)


            activity.startActivity(intent)
        }

    }


}