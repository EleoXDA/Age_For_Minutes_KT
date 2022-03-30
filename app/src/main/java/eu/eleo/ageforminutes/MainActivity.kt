package eu.eleo.ageforminutes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener { calculateDate() }
    }
    private fun calculateDate() {
        //select date of birth from user
        //calculate the days between now and them
        //convert days to hours by *24*60
        //display the time in box
    }
}
