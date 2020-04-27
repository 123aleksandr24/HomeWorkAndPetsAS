package com.example.a109intent;

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_mail.*
import kotlinx.android.synthetic.main.activity_main.*

class EmailActivity : AppCompatActivity(R.layout.activity_mail) {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    private fun setEmailParamsFromIntent () {
        val addresses = intent.getStringArrayExtra(Intent.EXTRA_EMAIL)
        val subject = intent.getStringArrayExtra(Intent.EXTRA_SUBJECT)

        addressTextView.text = addresses?.joinToString () ?: "Email address is not text"
        //subjectTextView.text = subject ?: "Subject is not set" ?????
        subjectTextView.text = (subject ?: "Subject is not set").toString()
    }
}
