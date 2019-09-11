package com.testing.picturespractice

import android.content.Intent
import android.os.Bundle
import android.content.Context
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.os.Handler
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_splashscreen.*

class ActivitySplashscreen : AppCompatActivity() {
    private var SPLASH_DURATION:Long = 5000
    private var context: Context =this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)
        var handler: Handler = Handler()

        //los archivos class son de tipo java
        handler.postDelayed({
            var intent: Intent = Intent(context, ActivityAccess::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            finish()
            context.startActivity(intent)
        }, SPLASH_DURATION)
    }
}
