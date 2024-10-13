package com.example.foodpanda

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EmailInputActivity : AppCompatActivity() {

    private lateinit var emailInput: EditText
    private lateinit var continueButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.email_input_activity)

        val signButton:Button = findViewById(R.id.btn_sign_up);
        signButton.setOnClickListener {
            // Navigate back to EmailInputActivity
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
            // Optional: finish this activity if you don't want it to remain in the stack

        }

//        emailInput = findViewById(R.id.email_input)
//        continueButton = findViewById(R.id.btn_continue)
//        val backButton: ImageView = findViewById(R.id.back_button)
//
//        // Enable Continue button if email is entered
//        emailInput.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(charSequence: CharSequence, start: Int, count: Int, after: Int) {}
//
//            override fun onTextChanged(charSequence: CharSequence, start: Int, before: Int, count: Int) {
//                val email = emailInput.text.toString().trim()
//                continueButton.isEnabled = email.isNotEmpty()
//                continueButton.setBackgroundColor(if (email.isNotEmpty())
//                    resources.getColor(R.color.primary_color)
//                else
//                    resources.getColor(android.R.color.darker_gray))
//            }
//
//            override fun afterTextChanged(editable: Editable) {}
//        })
//
//        // Handle Continue button click
//        continueButton.setOnClickListener {
//            val email = emailInput.text.toString().trim()
//            if (isValidEmail(email)) {
//                // Navigate to LoginActivity and pass email
//                val intent = Intent(this, LoginActivity::class.java).apply {
//                    putExtra("email", email)
//                }
//                startActivity(intent)
//            } else {
//                Toast.makeText(this, "Please enter a valid email", Toast.LENGTH_SHORT).show()
//            }
//        }
//
//        // Back button click event
//        backButton.setOnClickListener { finish() }
//    }

        // Simple email validation function
//    private fun isValidEmail(email: CharSequence): Boolean {
//        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
//    }
    }
}
