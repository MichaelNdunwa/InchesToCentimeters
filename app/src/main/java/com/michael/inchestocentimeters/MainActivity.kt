package com.michael.inchestocentimeters

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var inputValue: EditText
    private lateinit var convertButton: Button
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)
        inputValue = findViewById(R.id.inputValue)
        convertButton = findViewById(R.id.convertButton)
        textView = findViewById(R.id.textView)

        convertButton.setOnClickListener {
            val inches = inputValue.text
            if (inches.isNotBlank()) {
                val input = inches.toString().toDouble()
                val centimeter = input * 2.54
                textView.text = "$centimeter centimers"
                //to hide/close the keyboard:
                it.hideKeyboard()
            } else {
                Snackbar.make(
                    it, "No input, input value and try again..", Snackbar.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun View.hideKeyboard() {
        val inputMethodManager = context.getSystemService(
            Context. INPUT_METHOD_SERVICE
        ) as InputMethodManager

        inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
    }
}