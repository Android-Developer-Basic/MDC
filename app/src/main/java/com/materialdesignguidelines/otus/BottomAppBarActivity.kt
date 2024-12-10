package com.materialdesignguidelines.otus

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.getkeepsafe.taptargetview.TapTarget
import com.getkeepsafe.taptargetview.TapTargetView
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import es.dmoral.toasty.Toasty

class BottomAppBarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_app_bar)

        setListeners()
        showTapTargetForFAB()
    }

    private fun showTapTargetForFAB() {
        TapTargetView.showFor(
            this,
            TapTarget.forView(
                findViewById<FloatingActionButton>(R.id.fab),
                getString(R.string.custom_view_title),
                getString(R.string.description_for_view)
            ) // Все операторы ниже -- опциональны
                .titleTextSize(20)
                .titleTextColor(android.R.color.white)
                .descriptionTextSize(10)
                .cancelable(false)
        )
    }

    private fun setListeners() {
        val bottomAppBar = findViewById<BottomAppBar>(R.id.bottom_app_bar)
        bottomAppBar.setNavigationOnClickListener {
            Toasty.error(this, getString(R.string.this_is_an_error_toast), Toast.LENGTH_SHORT, true).show()
        }

        bottomAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.to_home -> {
                    Toasty.success(this, getString(R.string.success), Toast.LENGTH_SHORT, true).show()
                    true
                }

                R.id.search -> {
                    Toasty.info(this, getString(R.string.here_is_some_info_for_you), Toast.LENGTH_SHORT, true).show()
                    true
                }

                R.id.delete -> {
                    Toasty.warning(this, getString(R.string.beware_of_the_dog), Toast.LENGTH_SHORT, true).show()
                    true
                }

                else -> {
                    Toasty.warning(this, getString(R.string.beware_of_the_dog), Toast.LENGTH_SHORT, true).show()
                    true
                }
            }
        }

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            Toasty.normal(this, getString(R.string.normal_toast_w_o_icon)).show()
        }
    }
}