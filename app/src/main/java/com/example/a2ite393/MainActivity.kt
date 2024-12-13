package com.example.a2ite393

import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.TranslateAnimation
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val splashImage = findViewById<ImageView>(R.id.splashImage)
        val tapMessage = findViewById<TextView>(R.id.tvTap)
        val titleText = findViewById<TextView>(R.id.tvTitle)

        tapMessage.visibility = TextView.INVISIBLE
        titleText.visibility = TextView.INVISIBLE

        val screenWidth = resources.displayMetrics.widthPixels.toFloat()

        val animation = TranslateAnimation(-screenWidth, screenWidth, 0f, 0f)
        animation.duration = 4000
        animation.fillAfter = true

        val fadeIn = AlphaAnimation(0f, 1f)
        fadeIn.duration = 4000
        fadeIn.fillAfter = true

        splashImage.startAnimation(animation)
        titleText.startAnimation(fadeIn)

        animation.setAnimationListener(object : android.view.animation.Animation.AnimationListener {
            override fun onAnimationStart(animation: android.view.animation.Animation?) {}

            override fun onAnimationEnd(animation: android.view.animation.Animation?) {
                splashImage.visibility = View.INVISIBLE
                tapMessage.visibility = TextView.VISIBLE
            }

            override fun onAnimationRepeat(animation: android.view.animation.Animation?) {}
        })

        findViewById<View>(R.id.main).setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                v.performClick()
                startActivity(Intent(this, CountryPage::class.java))
                finish()
            }
            true
        }
    }
}
