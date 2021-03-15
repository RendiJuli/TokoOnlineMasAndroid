package com.ucoweb.tokoonline.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.ucoweb.tokoonline.MainActivity
import com.ucoweb.tokoonline.R
import com.ucoweb.tokoonline.app.ApiConfig
import com.ucoweb.tokoonline.helper.SharedPref
import com.ucoweb.tokoonline.model.ResponModel
import kotlinx.android.synthetic.main.activity_register.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

 lateinit var s:SharedPref

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        s =SharedPref (this)

            btn_register.setOnClickListener {
                    activRegister()
            }

            btn_google.setOnClickListener {
                dataDummy()
            }
    }

    fun dataDummy(){
        edt_nama.setText("Rendi")
        edt_email.setText("rendi12@gmail.com")
        edt_phone.setText("081321654987")
        edt_password.setText("12345678")

    }

    fun activRegister(){
        if (edt_nama.text.isEmpty()){
            edt_nama.error = "nama tidak boleh kosong"
            edt_nama.requestFocus()
            return
        } else if(edt_email.text.isEmpty()) {
            edt_email.error = "email tidak boleh kosong"
            edt_email.requestFocus()
            return
        } else if (edt_phone.text.isEmpty()){
            edt_phone.error = "no telp tidak boleh kosong"
            edt_phone.requestFocus()
            return
        } else if (edt_password.text.isEmpty()){
            edt_password.error = "password tidak boleh kosong"
            edt_password.requestFocus()
            return
        }
        pb.visibility = View.VISIBLE
        ApiConfig.instanceRetrofit.register(edt_nama.text.toString(),edt_email.text.toString(), edt_phone.text.toString(),
            edt_password.text.toString() ).enqueue(object: Callback<ResponModel>{

            override fun onFailure(call: Call<ResponModel>, t: Throwable) {
                pb.visibility = View.GONE
                Toast.makeText(this@Register, "Error:"+t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<ResponModel>, response: Response<ResponModel>) {
                pb.visibility = View.GONE
                val respon =response. body()!!

                if (respon.success == 1){
                    s.setStatusLogin(true)
                    val intent = Intent(this@Register, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                    startActivity(intent)
                    finish()
                    Toast.makeText(this@Register, "Selamat Datang:"+respon.user.name, Toast.LENGTH_SHORT).show()
                } else{
                    Toast.makeText(this@Register, "Error:"+respon.message, Toast.LENGTH_SHORT).show()
                }

            }

        })
    }


}