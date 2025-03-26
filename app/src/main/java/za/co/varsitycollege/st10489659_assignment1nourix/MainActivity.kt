package za.co.varsitycollege.st10489659_assignment1nourix

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val timeInput = findViewById<EditText>(R.id.timeInput)
        val suggestButton = findViewById<Button>(R.id.suggestButton)
        val resetButton = findViewById<Button>(R.id.resetButton)
        val mealSuggestion = findViewById<TextView>(R.id.mealSuggestion)

        // Suggest Button Click
        suggestButton.setOnClickListener {
            val timeOfDay = timeInput.text.toString().trim().lowercase()
            val suggestion = when
                                     (timeOfDay) {
                "morning" -> "breakfast: Eggs and toast with Coffee"
                "afternoon" -> "lunch: Chicken sandwich with salad"
                "mid-afternoon" -> "snack: Cookies and a smoothie"
                "dinner" -> "dinner: Grilled steak and pasta with juice"
                "dessert" -> "dessert: Ice cream"
                else -> "Invalid time entered. Try: morning, afternoon, dinner, etc."
            }

            mealSuggestion.text = suggestion
        }

        // Reset Button Click
        resetButton.setOnClickListener {
            timeInput.text.clear()
            mealSuggestion.text = ""
        }


    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}