package com.blackbirds.shakil.kotlinvideosplashscreen

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.WindowManager
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {

    var videoView: VideoView? = null
    var btnNextActivity: AppCompatButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(1)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        window.statusBarColor = Color.TRANSPARENT
        setContentView(R.layout.activity_main)

        videoView = findViewById(R.id.videoView)
        btnNextActivity = findViewById(R.id.btnNextActivity)

        val path = "android.resource://" + packageName + "/" + R.raw.video
        val uri = Uri.parse(path)
        videoView!!.setVideoURI(uri)
        videoView!!.start()

        videoView!!.setOnCompletionListener {
            if (isFinishing) {
                true
            }
            startActivity(Intent(this, SecondActivity::class.java))
            finish()
        }
    }
}