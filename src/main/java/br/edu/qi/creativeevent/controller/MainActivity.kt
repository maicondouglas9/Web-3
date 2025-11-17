package br.edu.qi.creativeevent.controller

import android.content.Intent
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.qi.creativeevent.R
import br.edu.qi.creativeevent.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var gestureDetector: GestureDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        this.binding = ActivityMainBinding.inflate(layoutInflater)
        this.gestureDetector = GestureDetector(this, SwipeListener())
        setContentView(this.binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        gestureDetector.onTouchEvent(event)
        return super.onTouchEvent(event)
    }

    private inner class SwipeListener : GestureDetector.SimpleOnGestureListener(){

        private val swipe_threshold = 100
        private val swipe_velocity_threshold = 100

        override fun onFling(
            e1: MotionEvent?,
            e2: MotionEvent,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            if (e1 == null || e2 == null) return false

            val diffX = e2.x - e1.x
            val diffY = e2.y - e1.y

            if ((kotlin.math.abs(diffX) > swipe_threshold && kotlin.math.abs(velocityX) > swipe_velocity_threshold) ||
                (kotlin.math.abs(diffY) > swipe_threshold && kotlin.math.abs(velocityY) > swipe_velocity_threshold)
            ) {

                val intent = Intent(this@MainActivity, ListaDeEventos::class.java)
                startActivity(intent)
                return true
            }

            return false
        }

    }

}