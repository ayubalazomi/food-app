package com.example.applecationfood

import android.content.Context

class SharedPref(context: Context) {
    companion object {
        const val FILE_KEY = "name_info"
        const val font_size = "fontsize"

    }

    private val sharedPref = context.getSharedPreferences(FILE_KEY, Context.MODE_PRIVATE)
    fun saveFontSize(size: String){
        sharedPref.edit()
            .putString(font_size, size)
            .apply()
    }

    fun getFontSize() : String{
        return  sharedPref.getString(font_size,"60")?:"60"
    }

}