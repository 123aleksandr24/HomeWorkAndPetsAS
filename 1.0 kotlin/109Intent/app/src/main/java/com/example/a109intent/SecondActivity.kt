package com.example.a109intent

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Message
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity: AppCompatActivity(R.layout.activity_second){

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        Log.d("LifeCycleTest", "SecondActivity|onCreate${hashCode()}")
        val message = intent.getStringExtra(KEY_MESSAGE)
        messageTextView.text = message
    }

    companion object{
        private const val KEY_MESSAGE = "message key"

        fun getIntent(context : Context, message: String): Intent {
            return Intent (context,SecondActivity::class.java)
                .putExtra(KEY_MESSAGE,message)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("LifeCycleTest", "SecondActivity|onStart${hashCode()}")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LifeCycleTest", "SecondActivity|onResume${hashCode()}")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LifeCycleTest", "SecondActivity|onPause${hashCode()}")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LifeCycleTest", "SecondActivity|onStop${hashCode()}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LifeCycleTest", "SecondActivity|onDestroy${hashCode()}")
    }

}