package eu.eleo.ageforminutes

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonDatePicker: Button = findViewById(R.id.buttonDatePicker)
        buttonDatePicker.setOnClickListener { datePicker() }
    }

    private fun datePicker() {
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(this, DatePickerDialog.OnDateSetListener {
                view, year, month, dayOfMonth ->
            Toast.makeText(this,
                "Date Picker works", Toast.LENGTH_SHORT).show()
                                                                  }
            , 2020, 1, 1).show()
    }
}
