package eu.eleo.ageforminutes

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    private var selectedDate : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonDatePicker: Button = findViewById(R.id.buttonDatePicker)
        selectedDate = findViewById(R.id.selectedDate)

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
                Toast.LENGTH_SHORT).show()

            val selectDate ="$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"

            selectedDate?.text = selectDate
                                                                  },
            year,
            month,
            day
        ).show()
    }
}
