package com.example.bookshow.UI.Activities

import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bookshow.R
import com.example.bookshow.UI.ActivityHolder
import com.example.bookshow.UI.MyApp

class MovieDetailActivity : AppCompatActivity() {

    private val seatViews: MutableList<View> = mutableListOf()
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var clickedSeats: BooleanArray

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_movie_detail_acivity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        ActivityHolder.activity = this
        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)

        for (i in 1..30) {
            val seatId = resources.getIdentifier("seat$i", "id", packageName)
            val seatView: View = findViewById(seatId)
            seatViews.add(seatView)
        }

        clickedSeats = BooleanArray(seatViews.size)

        restoreSeatBackgrounds()

        seatViews.forEachIndexed { index, view ->
            view.setOnClickListener {
                val seatKey = "seat${index + 1}"
                val selectedSeats = sharedPreferences.getStringSet("selectedSeats", mutableSetOf()) ?: mutableSetOf()

                if (selectedSeats.contains(seatKey)) {
                    view.setBackgroundColor(Color.WHITE)
                    selectedSeats.remove(seatKey)
                    clickedSeats[index] = false
                } else {
                    view.setBackgroundColor(Color.RED)
                    selectedSeats.add(seatKey)
                    clickedSeats[index] = true
                }


                sharedPreferences.edit().putStringSet("selectedSeats", selectedSeats).apply()


                (application as MyApp).clearSharedPrefAfterDelay(5_000)
            }
        }
    }

    fun restoreSeatBackgrounds() {
        val selectedSeats = sharedPreferences.getStringSet("selectedSeats", mutableSetOf()) ?: mutableSetOf()

        // Iterate through all seat views and update their background color
        seatViews.forEachIndexed { index, view ->
            val seatKey = "seat${index + 1}"
            if (selectedSeats.contains(seatKey)) {
                // If the seat is in the selected set, set background color to red
                view.setBackgroundColor(Color.RED)
                clickedSeats[index] = true
            } else {
                view.setBackgroundColor(Color.WHITE)
                clickedSeats[index] = false
            }
        }
    }

    companion object {
        var isActivityVisible = false
    }

    override fun onResume() {
        super.onResume()
        isActivityVisible = true
    }

    override fun onPause() {
        super.onPause()
        isActivityVisible = false
    }

    override fun onDestroy() {
        ActivityHolder.activity = null
        super.onDestroy()
    }

}