package com.ucoweb.tokoonline

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.add
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ucoweb.tokoonline.R.*
import com.ucoweb.tokoonline.activity.Login
import com.ucoweb.tokoonline.activity.Masuk
import com.ucoweb.tokoonline.fragment.AkunFragment
import com.ucoweb.tokoonline.fragment.HomeFragment
import com.ucoweb.tokoonline.fragment.KeranjangFragment
import com.ucoweb.tokoonline.helper.SharedPref


class MainActivity : AppCompatActivity() {

    val fragmentHome : Fragment = HomeFragment()
    val fragmentKeranjang :Fragment = KeranjangFragment()
    val fragmentAkun : Fragment = AkunFragment()
    val fm: FragmentManager = supportFragmentManager
    var active: Fragment = fragmentHome

    private lateinit var menu: Menu
    private lateinit var menuItems: MenuItem
    private lateinit var bottomNavigationView: BottomNavigationView
    //login
    private  var statusLogin = false
    private lateinit var s: SharedPref


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        s = SharedPref(this)

        setUpBottomNav()
    }

    fun setUpBottomNav(){
        fm.beginTransaction().add(R.id.container, fragmentHome).show(fragmentHome).commit()
        fm.beginTransaction().add(R.id.container, fragmentKeranjang).hide(fragmentKeranjang).commit()
        fm.beginTransaction().add(R.id.container, fragmentAkun).hide(fragmentAkun).commit()

        bottomNavigationView = findViewById(R.id.nav_view)

        menu = bottomNavigationView.menu
        menuItems = menu.getItem(0)
        menuItems.isChecked = true

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->

            when (item.itemId){
                R.id.navigation_home ->{
                    callfragment(0, fragmentHome)
                }

                R.id.navigation_keranjang ->{
                    callfragment(1, fragmentKeranjang)
                }
                R.id.navigation_Akun ->{
                    if (s.getStatusLogin()){
                        callfragment(2, fragmentAkun)
                    } else{
                        startActivity(Intent(this, Masuk::class.java))
                    }

                }
            }


            false }
    }

    fun callfragment(int: Int, fragment: Fragment){
        Log.d("Respons", "Akun")
        menuItems = menu.getItem(int)
        menuItems.isChecked = true
        fm.beginTransaction().hide(active).show(fragment).commit()
        active = fragment
    }
}
