package com.example.foodpanda

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class ProfileFormActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileForm()
        }
    }
}


@Composable
fun ProfileForm() {
    // Remember state for text fields
    val name = remember { mutableStateOf(TextFieldValue("")) }
    val email = remember { mutableStateOf(TextFieldValue("")) }
    val mobile = remember { mutableStateOf(TextFieldValue("")) }

    // Form layout
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Name TextField
        OutlinedTextField(
            value = name.value,
            onValueChange = { name.value = it },
            label = { Text(text = "Name") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        )

        // Email TextField
        OutlinedTextField(
            value = email.value,
            onValueChange = { email.value = it },
            label = { Text(text = "Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            shape = RoundedCornerShape(8.dp)
        )

        // Mobile Number TextField
        OutlinedTextField(
            value = mobile.value,
            onValueChange = { mobile.value = it },
            label = { Text(text = "Mobile Number") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        )

        // Spacer

        Spacer(modifier = Modifier.padding(vertical = 16.dp))

        // Connect with Google Button
        Button(
            onClick = { /*TODO: Handle Google Connect*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDB4437)), // Google color
            shape = RoundedCornerShape(50)
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Google Icon",
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = "Connect with Google",
                modifier = Modifier.padding(start = 8.dp),
                color = Color.White
            )
        }

        // Connect with Facebook Button
        Button(
            onClick = { /*TODO: Handle Facebook Connect*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4267B2)), // Facebook color
            shape = RoundedCornerShape(50)
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Facebook Icon",
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = "Connect with Facebook",
                modifier = Modifier.padding(start = 8.dp),
                color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileFormPreview() {
    ProfileForm()
}
