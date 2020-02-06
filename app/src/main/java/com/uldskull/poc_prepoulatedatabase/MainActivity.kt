package com.uldskull.poc_prepoulatedatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.koin.android.ext.android.inject

class MainActivity()  : AppCompatActivity() {

    val pocDao:PocDao by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkData()
    }


    fun checkData(){
        var all = this.pocDao.getAll()
        all.forEach {
            Log.i("NAME = ", it.name)
        }
    }


}


