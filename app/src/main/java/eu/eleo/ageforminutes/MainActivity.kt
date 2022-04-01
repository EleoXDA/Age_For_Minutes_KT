package eu.eleo.ageforminutes

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private var selectedDate : TextView? = null
    private var tvAgeInMinutes : TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonDatePicker: Button = findViewById(R.id.buttonDatePicker)
        selectedDate = findViewById(R.id.selectedDate)
        tvAgeInMinutes = findViewById(R.id.tvAgeInMinutes)
        buttonDatePicker.setOnClickListener { datePicker() }
    }

    private fun datePicker() {
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this, DatePickerDialog.OnDateSetListener {
                view, selectedYear, selectedMonth, selectedDayOfMonth ->
            Toast.makeText(this,
                "Year $selectedYear, ${selectedMonth+1}.month, and $selectedDayOfMonth day was picked",
                Toast.LENGTH_LONG).show()

            val selectDate ="$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"

            selectedDate?.text = selectDate

            val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

            val date = simpleDateFormat.parse(selectDate)

            val selectedDateInMinutes = date.time / (60 * 1000)
            val currentDateInMinutes = simpleDateFormat.parse(simpleDateFormat
                .format(System.currentTimeMillis())).time / (60 * 1000)
            val ageInMinutes = currentDateInMinutes - selectedDateInMinutes

            tvAgeInMinutes?.text = ageInMinutes.toString()
                                                                  },
            year,
            month,
            day
        ).show()
    }
}

