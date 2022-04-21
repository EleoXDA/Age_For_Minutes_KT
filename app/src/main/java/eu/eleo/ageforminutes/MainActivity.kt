package eu.eleo.ageforminutes

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    //region Variables
    private var selectedDate : TextView? = null
    private var tvAgeInMinutes : TextView? = null

    //endregion
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonDatePicker: Button = findViewById(R.id.buttonDatePicker)
        selectedDate = findViewById(R.id.selectedDate)
        tvAgeInMinutes = findViewById(R.id.tvAgeInMinutes)
        buttonDatePicker.setOnClickListener { datePicker() }
    }
    //region DatePicker
    private fun datePicker() {
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog(
            this,
            // Display a date picker when the user clicks "OK"
            { _, selectYear, selectMonth, selectDayOfMonth ->

                val selectDate = "$selectDayOfMonth/${selectMonth + 1}/$selectYear"

                selectedDate?.text = selectDate

                val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                val date = simpleDateFormat.parse(selectDate)

                date?.let {

                    val selectDateInMinutes = date.time / (60 * 1000)
                    val currentDate = simpleDateFormat.parse(
                        simpleDateFormat
                            .format(System.currentTimeMillis())
                    )
                    currentDate?.let {
                        val currentDateInMinutes = currentDate.time / (60 * 1000)
                        val ageInMinutes = currentDateInMinutes - selectDateInMinutes

                        tvAgeInMinutes?.text = ageInMinutes.toString()
                    }
                }
            },
            year,
            month,
            day)
        dpd.datePicker.maxDate = System.currentTimeMillis() - 86400000
        dpd.show ()
    }
}
