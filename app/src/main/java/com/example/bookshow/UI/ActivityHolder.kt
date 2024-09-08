package com.example.bookshow.UI

import com.example.bookshow.UI.Activities.MovieDetailActivity
import java.lang.ref.WeakReference

object ActivityHolder {
    private var activityRef: WeakReference<MovieDetailActivity>? = null

    var activity: MovieDetailActivity?
        get() = activityRef?.get()
        set(value) {
            activityRef = WeakReference(value)
        }
}