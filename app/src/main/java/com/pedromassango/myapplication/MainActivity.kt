package com.pedromassango.myapplication

import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button_first).setOnClickListener { view ->
            check(view)
        }
    }

    private fun check(view: View) {
        val clipManager = applicationContext.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

        val data = clipManager.hasPrimaryClip()
        val result = "Clipboard hasPrimaryClip: $data"

        Snackbar.make(view, result, Snackbar.LENGTH_LONG)
            .setAction("Action", null).show()

        findViewById<EditText>(R.id.textview_first).setText(result)
    }
}
