package com.materialdesignguidelines.otus

import android.app.Application
import com.google.android.material.color.DynamicColors
import es.dmoral.toasty.Toasty

class DynamicThemeApplication : Application() {

    override fun onCreate() {
        DynamicColors.applyToActivitiesIfAvailable(this)
        Toasty.Config.getInstance().apply()
        super.onCreate()
    }
}