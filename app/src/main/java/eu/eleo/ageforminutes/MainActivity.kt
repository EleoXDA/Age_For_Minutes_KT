package eu.eleo.ageforminutes

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonDatePicker: Button = findViewById(R.id.buttonDatePicker)
        buttonDatePicker.setOnClickListener {
            Toast.makeText(this,
                "Date Picker pressed", Toast.LENGTH_SHORT).show()
        }
    }

    private fun calculateDate() {
    }
}
