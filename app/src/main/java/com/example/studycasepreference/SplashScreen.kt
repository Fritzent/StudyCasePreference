package com.example.studycasepreference

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreen : AppCompatActivity() {

    companion object {
        private const val TIME_OUT:Long = 6000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val sharedPreferences = getSharedPreferences(Login.SP_NAME, Context.MODE_PRIVATE)
//        val statusInSp = sharedPreferences.getInt(STATUS)

        Handler().postDelayed({
            val contains = sharedPreferences.contains(Login.STATUS)

            if(contains){
                startActivity(Intent(this, MainActivity::class.java))

                finish()
            }else {
                startActivity(Intent(this, Login::class.java))
                finish()
            }
        }, TIME_OUT)
    }
}