package com.example.skkumate

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*

class DormMatchingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dorm_matching)

        val bedTime = findViewById<TextView>(R.id.bedtimeToggle)
        val wakeTime = findViewById<TextView>(R.id.wakeUpTimeToggle)
        val wakeUpTimeEditText = findViewById<TextView>(R.id.wakeUpTimeEditText)
        val bedtimeEditText = findViewById<TextView>(R.id.bedtimeEditText)
        val searchButton = findViewById<Button>(R.id.searchButton)

        // Toggle 'Before' / 'After' for wake time
        wakeTime.setOnClickListener {
            wakeTime.text = if (wakeTime.text == "Before") "After" else "Before"
        }

        // Toggle 'Before' / 'After' for bedtime
        bedTime.setOnClickListener {
            bedTime.text = if (bedTime.text == "Before") "After" else "Before"
        }

        // Set up TimePicker for wake-up time
        wakeUpTimeEditText.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            TimePickerDialog(this, android.R.style.Theme_Holo_Light_Dialog_NoActionBar,{ _, selectedHour, selectedMinute ->
                // Format the time as 12-hour (AM/PM)
                val amPm = if (selectedHour < 12) "AM" else "PM"
                val hourFormatted = if (selectedHour == 0 || selectedHour == 12) 12 else selectedHour % 12
                val formattedTime = String.format("%02d:%02d %s", hourFormatted, selectedMinute, amPm)
                wakeUpTimeEditText.text = formattedTime
            }, hour, minute, false).show()
        }

        // Set up TimePicker for bedtime
        bedtimeEditText.setOnClickListener {
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            TimePickerDialog(this, android.R.style.Theme_Holo_Light_Dialog_NoActionBar,{ _, selectedHour, selectedMinute ->
                // Format the time as 12-hour (AM/PM)
                val amPm = if (selectedHour < 12) "AM" else "PM"
                val hourFormatted = if (selectedHour == 0 || selectedHour == 12) 12 else selectedHour % 12
                val formattedTime = String.format("%02d:%02d %s", hourFormatted, selectedMinute, amPm)
                bedtimeEditText.text = formattedTime
            }, hour, minute, false).show()
        }

        // Handle search button click
        searchButton.setOnClickListener {
            // Implement search functionality here
        }


    }
}