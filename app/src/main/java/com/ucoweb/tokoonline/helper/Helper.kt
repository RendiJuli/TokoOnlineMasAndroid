package com.ucoweb.tokoonline.helper

import java.text.NumberFormat
import java.util.*

class Helper {

    fun changeRp(string: String): String {
       return NumberFormat.getCurrencyInstance(Locale("in", "ID")).format(Integer.valueOf(string))
    }
}