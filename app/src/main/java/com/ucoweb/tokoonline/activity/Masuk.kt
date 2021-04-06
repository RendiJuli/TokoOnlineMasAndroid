package com.ucoweb.tokoonline.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.ucoweb.tokoonline.R
import com.ucoweb.tokoonline.helper.SharedPref
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_masuk.*
import java.util.zip.Inflater

class Masuk : AppCompatActivity() {

    lateinit var s: SharedPref


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_masuk)

        s = SharedPref(this)

        mainButton()


    }
         private fun mainButton(){

                btn_prosesLogin.setOnClickListener {
                    startActivity(Intent(this, Login::class.java))
                }

                btn_register.setOnClickListener {
                    startActivity(Intent(this, Register::class.java))

                }

            }

}