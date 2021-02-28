package com.ucoweb.tokoonline.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager

import com.ucoweb.tokoonline.R
import com.ucoweb.tokoonline.adapter.AdapterSlider
import java.util.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    lateinit var vpslider: ViewPager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        vpslider = view.findViewById(R.id.vp_slider)

        val arrSlider = ArrayList<Int> ()
        arrSlider.add(R.drawable.slider1)
        arrSlider.add(R.drawable.slider2)
        arrSlider.add(R.drawable.slider3)

        val adapterSlider = AdapterSlider(arrSlider, activity)
        vpslider.adapter = adapterSlider

        return view
    }


}
