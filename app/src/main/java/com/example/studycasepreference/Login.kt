package com.example.studycasepreference

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {
    companion object {
        const val SP_NAME = "data_user"
        const val FIELD_USERNAME = "username"
        const val FIELD_PASSWORD = "password"
        const val STATUS = "status"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val sharedPreferences = getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
//        val usernameInSp = sharedPreferences.getString(FIELD_USERNAME, "No Data")
//        val passwordInSp = sharedPreferences.getString(FIELD_PASSWORD, "No Data")
        val statusInSp = sharedPreferences.getInt(STATUS, 0)



        btnLogin.setOnClickListener {
            if(cbRemember.isChecked) {
                val editor = sharedPreferences.edit()

                editor.putString(FIELD_USERNAME, etUsername.text.toString())
                editor.putString(FIELD_PASSWORD, etPassword.text.toString())
                editor.putInt(STATUS, 1)

                val toastStatus = editor.commit()

                if(toastStatus){
                    Toast.makeText(this, "Data Saved", Toast.LENGTH_LONG).show()
                    startActivity(Intent(this, MainActivity::class.java))
                }else{
                    Toast.makeText(this, "Data Fail to Save", Toast.LENGTH_LONG).show()
                }
            }else {
                val editor = sharedPreferences.edit()

                editor.putString(FIELD_USERNAME, etUsername.text.toString())
                editor.putString(FIELD_PASSWORD, etPassword.text.toString())
                editor.putInt(STATUS, 0)

                val toastStatus = editor.commit()

                if(toastStatus){
                    Toast.makeText(this, "Data Saved", Toast.LENGTH_LONG).show()
                    startActivity(Intent(this, MainActivity::class.java))
                }else{
                    Toast.makeText(this, "Data Fail to Save", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}