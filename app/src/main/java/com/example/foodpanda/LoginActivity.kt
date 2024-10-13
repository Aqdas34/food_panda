//package com.example.foodpanda
//
//
//
//import android.content.Intent
//import android.os.Bundle
//import android.widget.Button
//import androidx.appcompat.app.AppCompatActivity
//import com.google.android.material.snackbar.Snackbar
//
//class LoginActivity : AppCompatActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_login)
//
////        // Buttons
////        val googleButton = findViewById<Button>(R.id.googleButton)
////        val facebookButton = findViewById<Button>(R.id.facebookButton)
////        val emailButton = findViewById<Button>(R.id.emailButton)
//
//        // Google button click listener
////        googleButton.setOnClickListener {
////            // Google login logic here
////            Snackbar.make(it, "Google login not yet implemented", Snackbar.LENGTH_SHORT).show()
////        }
////
////        // Facebook button click listener
////        facebookButton.setOnClickListener {
////            // Facebook login logic here
////            Snackbar.make(it, "Facebook login not yet implemented", Snackbar.LENGTH_SHORT).show()
////        }
////
////        // Email button click listener
////        emailButton.setOnClickListener {
////            // Email login logic here, you can open another activity
////            Snackbar.make(it, "Email login not yet implemented", Snackbar.LENGTH_SHORT).show()
////        }
//    }
//}


package com.example.foodpanda

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login) // Make sure this layout exists
        // Back to Email Input button click event
        val backButton: Button = findViewById(R.id.btn_email)
        backButton.setOnClickListener {
            // Navigate back to EmailInputActivity
            val intent = Intent(this, EmailInputActivity::class.java)
            startActivity(intent)
            // Optional: finish this activity if you don't want it to remain in the stack

        }



    }
}
