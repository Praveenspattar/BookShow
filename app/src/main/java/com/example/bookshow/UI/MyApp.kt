package com.example.bookshow.UI

import android.app.Application
import android.os.Handler
import android.os.Looper
import com.example.bookshow.UI.Activities.MovieDetailActivity

class MyApp : Application() {

    private val handler = Handler(Looper.getMainLooper())
    private var clearPrefRunnable: Runnable? = null

    private fun restoreSeatsIfActivityVisible() {
        val activity : MovieDetailActivity? = ActivityHolder.activity
        if (activity != null && MovieDetailActivity.isActivityVisible) {
            activity.restoreSeatBackgrounds()
        }
    }

    fun clearSharedPrefAfterDelay(delayMillis: Long) {

        clearPrefRunnable?.let { handler.removeCallbacks(it) }

        clearPrefRunnable = Runnable {
            val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
            sharedPreferences.edit().clear().apply()
            restoreSeatsIfActivityVisible()
        }

        handler.postDelayed(clearPrefRunnable!!, delayMillis)
    }

}