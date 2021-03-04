package com.mfathurz.activityfragmentintent

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit

class SecondActivity : AppCompatActivity() {

    private lateinit var btnShowFragment: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        Log.d("SecondActivity", "onCreate ")

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<FirstFragment>(R.id.fragment_container)
                addToBackStack(null)
            }
        }

        btnShowFragment = findViewById(R.id.btn_show_fragment)

        btnShowFragment.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<SecondFragment>(R.id.fragment_container)
                addToBackStack(null)
            }
        }
    }

    override fun onBackPressed() {
        supportFragmentManager.popBackStack()
        if(supportFragmentManager.backStackEntryCount <=1){
            super.onBackPressed()
        }
    }

    /**
     * fungsi-fungsi dibawah ini di override agar bisa tahu activity sedang berada di state mana
     *
     * untuk melihatnya run aplikasi nya terus lihat log cat bagian debug
     */

    override fun onStart() {
        super.onStart()
        Log.d("SecondActivity", "onStart ")
    }

    override fun onResume() {
        super.onResume()
        Log.d("SecondActivity", "onResume ")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("SecondActivity", "onRestart ")
    }

    override fun onPause() {
        super.onPause()
        Log.d("SecondActivity", "onPause ")
    }

    override fun onStop() {
        super.onStop()
        Log.d("SecondActivity", "onStop ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("SecondActivity", "onDestroy ")
    }
}