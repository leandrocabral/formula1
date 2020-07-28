package com.leandroid.formula1.splash

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.leandroid.formula1.MainActivity
import com.leandroid.formula1.R

class SplashScreenActivity : AppCompatActivity() {

    lateinit var rotateAnimation: Animation
    private val splashScreenLogo by lazy<ImageView> { findViewById(R.id.iv_logo) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)
        rotateAnimation()
        closeSplashScreen()
    }

    private fun rotateAnimation() {
        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate)
        splashScreenLogo.startAnimation(rotateAnimation)
    }

    private fun closeSplashScreen() {
        object : CountDownTimer(5000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                val intent = Intent(this@SplashScreenActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }.start()
    }
}