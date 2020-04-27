package com.example.a109intent;

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_course.*

class CourseActivity : AppCompatActivity(R.layout.activity_course){

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        handleIntentData()
    }

    //https://skillbox.ru/course/profession-android-developer/

    private fun handleIntentData () {
        intent.data?.lastPathSegment?.let { courseName ->
            courseNameTextView.text = courseName
        }
    }
}