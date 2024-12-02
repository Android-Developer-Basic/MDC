package com.materialdesignguidelines.otus

import android.app.Application
import com.google.android.material.color.DynamicColors

class DynamicThemeApplication : Application() {

    override fun onCreate() {
        DynamicColors.applyToActivitiesIfAvailable(this)
        super.onCreate()
    }
}