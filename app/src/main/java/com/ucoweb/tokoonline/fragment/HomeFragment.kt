package com.ucoweb.tokoonline.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager

import com.ucoweb.tokoonline.R
import com.ucoweb.tokoonline.adapter.AdapterProduk
import com.ucoweb.tokoonline.adapter.AdapterSlider
import com.ucoweb.tokoonline.model.Produk
import java.util.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    lateinit var vpslider: ViewPager
    lateinit var rvProduk: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        vpslider = view.findViewById(R.id.vp_slider)
        rvProduk = view.findViewById(R.id.rv_produk)

        val arrSlider = ArrayList<Int> ()
        arrSlider.add(R.drawable.slider1)
        arrSlider.add(R.drawable.slider2)
        arrSlider.add(R.drawable.slider3)

        val adapterSlider = AdapterSlider(arrSlider, activity)
        vpslider.adapter = adapterSlider

        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL

        rvProduk.adapter =AdapterProduk(arrProduk)
        rvProduk.layoutManager= layoutManager


        return view
    }

        val arrProduk: ArrayList<Produk>get(){
          val arr = ArrayList<Produk>()
            val p1= Produk()
            p1.nama ="New Iphone 11 Pro Max"
            p1.harga = "Rp.23.500.000"
            p1.gambar = R.drawable.iphone_11

            val p2= Produk()
            p2.nama ="New Iphone X"
            p2.harga = "Rp.18.000.000"
            p2.gambar = R.drawable.iphone_x

            val p3= Produk()
            p3.nama ="New Iphone 8"
            p3.harga = "Rp.20.500.000"
            p3.gambar = R.drawable.iphone_8

            val p4= Produk()
            p4.nama ="New Iphone 7"
            p4.harga = "Rp.12.500.000"
            p4.gambar = R.drawable.iphone_7_plus

            arr.add(p1)
            arr.add(p2)
            arr.add(p3)
            arr.add(p4)

            return arr
        }
}
