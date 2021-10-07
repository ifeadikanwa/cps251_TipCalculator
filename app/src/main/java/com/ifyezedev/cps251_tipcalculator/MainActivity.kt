package com.ifyezedev.cps251_tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ifyezedev.cps251_tipcalculator.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.calculateButton.setOnClickListener{
            calculateTip()
        }
    }

    private fun calculateTip() {
        val errorMsg = "YOU MUST ENTER A BILL AMOUNT"
        val billString = binding.billEditText.editableText.toString()

        if (billString.trim().isEmpty()){
            binding.tipTextView.text = errorMsg
        }
        else {
            val billDouble = billString.toDouble()
            val tip = "The tips are as follows:\n" +
                    "\n" +
                    "10% = " + String.format("%.2f", billDouble+(billDouble*0.1))  +"\n" +
                    "15% = " + String.format("%.2f", billDouble+(billDouble*0.15)) +"\n" +
                    "20% = " + String.format("%.2f", billDouble+(billDouble*0.2))

            binding.tipTextView.text = tip
        }
    }
}