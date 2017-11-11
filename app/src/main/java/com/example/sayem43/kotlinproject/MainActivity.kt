package com.example.sayem43.kotlinproject

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var parent: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        parent = findViewById(R.id.parent_main)
        tv_text.text = getString(R.string.dummy_text)

        btn_ok.setOnLongClickListener(View.OnLongClickListener {

            val value = "Saadat"

            Toast.makeText(this, "Button is pressed for a long long time!\n" +
                    "Please Leave her alone!!!", Toast.LENGTH_LONG).show()

            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(Constants.USER_NAME, value)
            startActivity(intent)

            return@OnLongClickListener false  // No change whether true or false
        })

        btn_ok.setOnClickListener({
            if (tv_text.text == getString(R.string.dummy_text)) {
                tv_text.text = getString(R.string.new_text)
                btn_ok.text = getString(R.string.go_back)
            } else {
                tv_text.text = getString(R.string.dummy_text)
                btn_ok.text = getString(R.string.go_ok)
            }

            // Snackbar callbasck

            val snackbar = Snackbar
                    .make(parent!!, "Message is deleted", Snackbar.LENGTH_LONG)
                    .setAction("UNDO") {
                        val snackbar1 = Snackbar.make(parent!!, "Message is restored!", Snackbar.LENGTH_SHORT)
                        snackbar1.show()
                    }

            snackbar.show()

        })
    }
}
