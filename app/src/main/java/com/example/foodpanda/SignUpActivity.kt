package com.example.foodpanda
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodpanda.ui.theme.FoodPandaTheme
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodPandaTheme {
                SignUpScreen()
            }
        }
    }
}

@Composable
fun SignUpScreen() {
    val context = LocalContext.current
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf("") }

    // Email Validation function
    fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    // Password Validation function
    fun isValidPassword(password: String): Boolean {
        return password.length >= 6
    }

    // Remove leading/trailing spaces
    fun trimEmail(email: String): String {
        return email.trim()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Header Text
        Text(
            text = "Sign Up", // Replace with your string resource
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Email Input Field
        TextField(
            value = email,
            onValueChange = { email = it
                            emailError=""},
            label = { Text(text = "Email") }, // Replace with your string resource
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
                .background(Color.Transparent), // Background color
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next
            )
        )
        if (emailError.isNotEmpty()) {
            Text(
                text = emailError,
                color = Color.Red,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }

        // Password Input Field
        TextField(
            value = password,
            onValueChange = { password = it
                            passwordError=""},
            label = { Text(text = "Password") }, // Replace with your string resource
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
                .background(Color.Transparent), // Background color
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next
            )
        )
        if (passwordError.isNotEmpty()) {
            Text(
                text = passwordError,
                color = Color.Red,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }

        // Confirm Password Input Field
        TextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text(text = "Confirm Password") }, // Replace with your string resource
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
                .background(Color.Transparent), // Background color
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            )
        )

        // Continue Button
        Button(
            onClick = {
                val trimmedEmail = trimEmail(email)

                // Validate email and password
                if (!isValidEmail(trimmedEmail)) {
                    emailError = "Please enter a valid email address"
                } else if (!isValidPassword(password)) {
                    passwordError = "Password must be at least 6 characters long"
                }
                else
                {
                    // Handle sign up click, e.g., validate and proceed
                    if (email.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
                        // Show error message (you can use Toast or Snackbar)
                        Toast.makeText(context, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                        return@Button
                    }

                    if (password != confirmPassword) {
                        // Show error message for password mismatch
                        Toast.makeText(context, "Passwords do not match", Toast.LENGTH_SHORT).show()
                        return@Button
                    }

                    // Create user with Firebase
                    val firebaseAuth = FirebaseAuth.getInstance()
                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                // Sign-up successful, navigate to the next screen
                                val intent = Intent(context, LoginActivity::class.java) // Replace with your next activity
                                context.startActivity(intent)
                                // Optionally, finish the current activity
                            } else {
                                // Handle sign-up failure (show error message)
                                Toast.makeText(context, "Sign up failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                            }
                        }
                }

            },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Blue),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.White
            )
        ) {
            Text(text = "Sign Up") // Replace with your string resource
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Sign Up Row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Don't have an account? Text
            Text(
                text = "Don't have an account?", // Replace with your string resource
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.padding(end = 8.dp)
            )

            // Login Button
            TextButton(
                onClick = {
                    val intent = Intent(context, EmailActivity::class.java)
                    context.startActivity(intent)
                }
            ) {
                Text(
                    text = "Login", // Replace with your string resource
                    color = Color.Blue
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    SignUpScreen()
}
