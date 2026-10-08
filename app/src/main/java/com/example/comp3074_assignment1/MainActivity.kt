package com.example.comp3074_assignment1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.EditText
import android.widget.TextView
import android.content.Intent

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n", "DefaultLocale")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val calculateButton = findViewById<Button>(R.id.CalculateButton)
        val aboutButton = findViewById<Button>(R.id.AboutButton)
        val hoursInput = findViewById<EditText>(R.id.HoursInput)
        val hourlyRate = findViewById<EditText>(R.id.HourlyRate)
        val taxRate = findViewById<EditText>(R.id.TaxRate)

        val payOutput = findViewById<TextView>(R.id.PayOutput)
        val overtimeOutput = findViewById<TextView>(R.id.overtimeOutput)
        val totalPayOutput = findViewById<TextView>(R.id.TotalPay)
        val taxOutput = findViewById<TextView>(R.id.TaxOutput)


        calculateButton.setOnClickListener{
            val hours = hoursInput.text.toString().toDouble()
            val rate = hourlyRate.text.toString().toDouble()
            val tax = taxRate.text.toString().toDouble()


            val pay: Double
            val overtimePay: Double

            if (hours <= 40){
                pay = hours * rate
                overtimePay = 0.0

            } else {
                pay = 40 * rate
                overtimePay = (hours - 40) * rate * 1.5

            }

            val totalPay = pay + overtimePay
            val taxAmount = pay * (tax / 100)

            payOutput.text = String.format("Pay: $%.2f", pay)
            overtimeOutput.text = String.format("Overtime Pay: $%.2f", overtimePay)
            totalPayOutput.text = String.format("Total Pay: $%.2f", totalPay)
            taxOutput.text = String.format("Tax: $%.2f", taxAmount)




        }

        aboutButton.setOnClickListener{
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)

        }













        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}