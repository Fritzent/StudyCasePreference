package com.example.studycasepreference

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences(Login.SP_NAME, Context.MODE_PRIVATE)
        val usernameInSp = sharedPreferences.getString(Login.FIELD_USERNAME, "No Data")

        tvNama.text = usernameInSp
    }
}