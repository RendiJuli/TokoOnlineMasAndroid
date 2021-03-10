package com.ucoweb.tokoonline.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.ucoweb.tokoonline.R
import com.ucoweb.tokoonline.app.ApiConfig
import com.ucoweb.tokoonline.helper.SharedPref
import com.ucoweb.tokoonline.model.ResponModel
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.btn_login
import kotlinx.android.synthetic.main.activity_masuk.*
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.zip.Inflater

class Login : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_login.setOnClickListener {
            login()

        }

    }

    fun login() {
        if (edt_logemail.text.isEmpty()) {
            edt_email.error = "email harus diisi"
            edt_email.requestFocus()
            return

        } else if (edt_logpassword.text.isEmpty()) {
            edt_logpassword.error = "Password harus diisi"
            edt_logpassword.requestFocus()
            return

        }

        ApiConfig.instanceRetrofit.login(edt_logemail.text.toString(),
            edt_logpassword.text.toString() ).enqueue(object: Callback<ResponModel>{

            override fun onFailure(call: Call<ResponModel>, t: Throwable) {
                Toast.makeText(this@Login, "Error:"+t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<ResponModel>, response: Response<ResponModel>) {
                val respon =response. body()!!

                if (respon.success == 1){
                    Toast.makeText(this@Login, "Selamat Datang:"+respon.user.email, Toast.LENGTH_SHORT).show()
                } else{
                    Toast.makeText(this@Login, "Error:"+respon.message, Toast.LENGTH_SHORT).show()
                }

            }

        })
    }
}



