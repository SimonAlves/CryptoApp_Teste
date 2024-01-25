package com.example.cryptoapp_teste
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo

class SplashScreenAnimation : AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen_animation)

        val splashImage = findViewById<ImageView>(R.id.splashimagem)

        YoYo.with(Techniques.FadeIn)
            .duration(3000)
            .onEnd {
                Handler().postDelayed({
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }, SPLASH_TIME_OUT)
            }
            .playOn(splashImage)
    }
}
