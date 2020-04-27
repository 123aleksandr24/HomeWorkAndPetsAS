package com.example.a109intent

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.util.Patterns
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        private val cameraLauncher = prepareCall (ActivityResultContracts.TakePicture()) { bitmap ->
            bitmap :? toast("Photo capture was cancelled")
            resultPhotoImageView.setImageBitmap(bitmap)
        }

        Log.d("LifeCycleTest", "MAinActivity|onCreate${hashCode()}")

       startExplicitButton.setOnClickListener {

           val messageText = messageEditText.text.toString()
           val activityClass = SecondActivity :: class.java  // получение класса котлин
           startActivity(SecondActivity.getIntent(this,messageText))
       }

        takePhotoButton.setOnClickListener{
            dispatchTakePictureIntent()
        }

        sendEmailButton.setOnClickListener {
            dispatchEmailIntent()
        }


    }

    private fun dispatchTakePictureIntent() {

        val isCameraPermissionsGranted = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED// почему?

        if (!isCameraPermissionsGranted){
            Activity.requestPermission (this , arrayOf(Manifest.permission.CAMERA), 123)
        } else {
            cameraLauncher.launch (null)
        }
    }

    private fun dispatchEmailIntent() {

            val emailAdress = emailAddressEditText.text.toString()
            val emailSubject = subjectEditText.text.toString()

            val isEmailValid = Patterns.EMAIL_ADDRESS.matcher(emailAdress).matches()

            if (!isEmailValid) {
                toast("Enter valid email")
            } else {
                val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:")
                    putExtra(Intent.EXTRA_EMAIL, arrayOf(emailAdress))
                    putExtra(Intent.EXTRA_SUBJECT,emailSubject)
                }

                if (intent.resolveActivity(packageManager) != null){
                    startActivity(emailIntent)
                } else {
                    toast ("No component to handle intent")
                }

            }

    }

    private fun toast(text : String) {
        Toast.makeText(this,text,Toast.LENGTH_LONG).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == PHOTO_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK){
                val previewBitMap = data?.getParcelableArrayExtra("data") as? Bitmap
                resultPhotoImageView.setImageBitmap(previewBitMap)
            }else {
                toast("Photo capture was cancelled")
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("LifeCycleTest", "MAinActivity|onStart${hashCode()}")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LifeCycleTest", "MAinActivity|onResume${hashCode()}")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LifeCycleTest", "MAinActivity|onPause${hashCode()}")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LifeCycleTest", "MAinActivity|onStop${hashCode()}")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LifeCycleTest", "MAinActivity|onDestroy${hashCode()}")
    }

    companion object{
        private const val PHOTO_REQUEST_CODE = 123
    }

}
