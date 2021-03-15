package com.ucoweb.tokoonline.fragment


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.ucoweb.tokoonline.MainActivity

import com.ucoweb.tokoonline.R
import com.ucoweb.tokoonline.activity.Login
import com.ucoweb.tokoonline.helper.SharedPref

/**
 * A simple [Fragment] subclass.
 */
class AkunFragment : Fragment() {

    lateinit var s: SharedPref
    lateinit var btnLogout: TextView
    lateinit var tvNama: TextView
    lateinit var tvEmail: TextView
    lateinit var tvPhone: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_akun, container, false)

        init(view)

        s = SharedPref(requireActivity())

        btnLogout.setOnClickListener {
            s.setStatusLogin(false)
        }

        setData()
        return view

    }

    fun setData() {

        if (s.getUser() == null) {
            val intent = Intent(activity, Login::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            return

        }

        val user = s.getUser()!!

        tvNama.text = user.name
        tvEmail.text =user.email
        tvPhone.text = user.phone

    }

    private fun init(view: View) {
        btnLogout = view.findViewById(R.id.btn_logout)
        tvNama = view.findViewById(R.id.tv_nama)
        tvPhone= view.findViewById(R.id.tv_phone)
        tvEmail=view.findViewById(R.id.tv_email)

    }


}
