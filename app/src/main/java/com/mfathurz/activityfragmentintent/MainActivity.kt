package com.mfathurz.activityfragmentintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button


class MainActivity : AppCompatActivity() {

    private lateinit var btnToSecondActivity : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("MainActivity", "onCreate ")

        btnToSecondActivity = findViewById(R.id.btn_to_second_activity)

        btnToSecondActivity.setOnClickListener {
            val intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }

    }

    /**
     * fungsi-fungsi dibawah ini di override agar bisa tahu activity sedang berada di state mana
     *
     * untuk melihatnya run aplikasi nya terus lihat log cat bagian debug
     */
    override fun onStart() {
        super.onStart()
        Log.d("MainActivity", "onStart ")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainActivity", "onResume ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("MainActivity", "onRestart ")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainActivity", "onPause ")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainActivity", "onStop ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainActivity", "onDestroy ")
    }
}