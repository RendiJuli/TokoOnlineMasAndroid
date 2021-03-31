package com.ucoweb.tokoonline.model

import java.util.ArrayList

class ResponModel {
        var success = 0
        lateinit var message:String
        var user= User()
        var products: ArrayList<Produk> = ArrayList()


}