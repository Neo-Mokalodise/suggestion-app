package za.ac.iie.assigment1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.sql.Time

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Input declaration
        val etTime = findViewById<EditText>(R.id.etTime)

        //Button declaration
        val btnCheck = findViewById<Button>(R.id.btnCheck)
        val btnReset = findViewById<Button>(R.id.btnReset)

        //Output declaration
        val tvResult = findViewById<TextView>(R.id.tvResult)


        btnCheck.setOnClickListener {

            //Rules 1
            val time = etTime.text.toString().trim().lowercase()
            var sending: String = ""


            if (time.isEmpty()) {
                 sending = "Please enter time of day to get suggestion"

            } else if (time == "morning") {
                sending = "send a 'Good morning' text to a family member"

            } else if (time == "mid morning") {
                sending = "Reach out to a college with a quick'Thank you.'"

            } else if (time == "afternoon") {
                sending = "Share a funny meme or interesting link with a friend."

            } else if (time == "afternoon snack time") {
                sending = "send a quick 'thinking of you' message."

            } else if (time == "dinner") {
                sending = "Call a friend or relative for 5 minutes for a catch up."

            } else if (time == "after dinner") {
                sending = "Leave a thoughtful comment on a friend's post"

            } else if (time == "night") {
                sending = "Leave a thoughtful comment on a friend's post"
            }
            tvResult.text = sending
        }

        btnReset.setOnClickListener {
            etTime.text.clear()
            tvResult.text = ""
        }
    }
}

