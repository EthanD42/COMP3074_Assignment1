package com.example.comp3074_assignment1

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val calculateButton = findViewById<Button>(R.id.CalculateButton)
        val hoursInput = findViewById<EditText>(R.id.HoursInput)
        val hourlyRate = findViewById<EditText>(R.id.HourlyRate)
        val taxRate = findViewById<EditText>(R.id.TaxRate)


        calculateButton.setOnClickListener{
            val hours = hoursInput.text.toString().toDouble()
            val rate = hourlyRate.text.toString().toDouble()
            val tax = taxRate.text.toString().toDouble()

        }









        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}