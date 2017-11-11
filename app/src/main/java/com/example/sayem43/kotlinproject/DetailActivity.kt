package com.example.sayem43.kotlinproject

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private var parent_details: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        parent_details = findViewById(R.id.parent_details)
        val userName = intent.getStringExtra(Constants.USER_NAME)
        requireNotNull(userName) { "no user_id provided in Intent extras" }
        tv_detailed.text = userName
        val snackbar = Snackbar
                .make(parent_details!!, "No internet connection!", Snackbar.LENGTH_LONG)
                .setAction("RETRY") { }

// Changing message text color
        snackbar.setActionTextColor(Color.RED)

// Changing action button text color
        val sbView = snackbar.view
        val textView = sbView.findViewById<View>(android.support.design.R.id.snackbar_text) as TextView
        textView.setTextColor(Color.YELLOW)

        snackbar.show()
    }
}
