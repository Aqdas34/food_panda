//package com.example.foodpanda
//
//import android.content.Context
//import android.content.Intent
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.WindowInsets
//import androidx.compose.foundation.layout.asPaddingValues
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.systemBars
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowForward
//import androidx.compose.material.icons.filled.Build
//import androidx.compose.material.icons.filled.Call
//import androidx.compose.material.icons.filled.Favorite
//import androidx.compose.material.icons.filled.FavoriteBorder
//import androidx.compose.material.icons.filled.LocationOn
//import androidx.compose.material.icons.filled.ShoppingCart
//import androidx.compose.material.icons.filled.Star
//import androidx.compose.material3.Icon
//import androidx.compose.material3.Text
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.Card
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.TextButton
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//
//@Composable
//fun ProfileActivity(context: Context) {
//    val insets = WindowInsets.systemBars.asPaddingValues() // Get system bar insets
//    val scrollState = rememberScrollState()
//
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(Color(0xFFFCE4EC)) // Light pink background
//            .padding(20.dp)
//            .padding(top = insets.calculateTopPadding()) // Add top padding
//            .padding(bottom = 70.dp) // Add bottom padding
//            .verticalScroll(scrollState)
//    ) {
//        // Header Row with "Account" and Shopping Cart Icon
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceBetween,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Text(
//                text = "Account",
//                style = MaterialTheme.typography.titleMedium,
//                fontWeight = FontWeight.Bold
//            )
//            Icon(
//                imageVector = Icons.Default.ShoppingCart,
//                contentDescription = "Settings Icon"
//            )
//        }
//
//        // User Profile Section
//        Column(
//            modifier = Modifier.padding(vertical = 16.dp)
//        ) {
//            Text(
//                text = "Aqdas",
//                style = MaterialTheme.typography.headlineSmall,
//                fontWeight = FontWeight.Bold
//
//            )
//
//            TextButton(
//                onClick = {
//                    val intent = Intent(context, ProfileFormActivity::class.java)
//                    context.startActivity(intent)
//
//                },
//                colors = ButtonDefaults.textButtonColors(contentColor = Color.Gray)
//            ) {
//                Text(text = "View profile")
//            }
//        }
//
//        // Card for Orders, Favourites, Addresses
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(vertical = 6.dp),
////            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            ProfileCardItem("Orders", Icons.Default.ShoppingCart)
//            ProfileCardItem("Favourites", Icons.Default.Favorite)
//            ProfileCardItem("Addresses", Icons.Default.LocationOn)
//        }
//
//        // Pandapay Credit Section
//        Card(
//            shape = RoundedCornerShape(8.dp),
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(vertical = 8.dp)
//        ) {
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(16.dp),
//                horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//                Text(text = "Pandapay Credit")
//                Text(text = "Rs. 0.00", fontWeight = FontWeight.Bold)
//            }
//        }
//
//        // Perks Section
//        Text(
//            text = "Perks for you",
//            style = MaterialTheme.typography.titleMedium,
//            fontWeight = FontWeight.Bold,
//            modifier = Modifier.padding(vertical = 16.dp)
//        )
//        ProfilePerksItem("Become a pro", Icons.Default.Star)
//        ProfilePerksItem("panda rewards", Icons.Default.FavoriteBorder)
//        ProfilePerksItem("Vouchers", Icons.Default.Star)
//        ProfilePerksItem("Invite friends", Icons.Default.Star)
//
//        // General Section
//        Text(
//            text = "General",
//            style = MaterialTheme.typography.titleMedium,
//            fontWeight = FontWeight.Bold,
//            modifier = Modifier.padding(vertical = 16.dp)
//        )
//        ProfileGeneralItem("Help center", Icons.Default.Build)
//        ProfileGeneralItem("foodpanda for business", Icons.Default.Call)
//        ProfileGeneralItem("Terms & policies", Icons.Default.Build)
//
//        // Log out Button
//        Button(
//            onClick = { /* TODO: Add logout functionality */ },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(vertical = 16.dp),
//            shape = RoundedCornerShape(50)
//        ) {
//            Text(text = "Log out")
//        }
//
//        Spacer(modifier = Modifier.height(16.dp))
//    }
//}
//
//
//
//
//@Composable
//fun ProfileCardItem(label: String, icon: androidx.compose.ui.graphics.vector.ImageVector) {
//    Button(
//        onClick = { /*TODO*/ },
//        modifier = Modifier.padding(2.dp),
//
//    ) {
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Icon(imageVector = icon, contentDescription = label)
//            Text(text = label)
//        }
//    }
//}
//
//@Composable
//fun ProfilePerksItem(label: String,icon: androidx.compose.ui.graphics.vector.ImageVector) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(vertical = 8.dp),
//        horizontalArrangement = Arrangement.SpaceBetween
//    ) {
//        Row()
//        {
//            Icon(imageVector = icon, contentDescription = label, modifier = Modifier.size(24.dp)) // Replace with arrow icon
//            Text(text = label,modifier = Modifier.padding(start = 16.dp))
//
//        }
//
//        Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "Arrow") // Replace with an arrow icon if needed
//
//
//    }
//
//
//}
//
//@Composable
//fun ProfileGeneralItem(label: String, icon: androidx.compose.ui.graphics.vector.ImageVector) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(vertical = 8.dp),
//        horizontalArrangement = Arrangement.SpaceBetween,
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Row(verticalAlignment = Alignment.CenterVertically) {
//            Icon(
//                imageVector = icon,
//                contentDescription = label,
//                modifier = Modifier.size(24.dp)
//            )
//            Text(
//                text = label,
//                modifier = Modifier.padding(start = 16.dp)
//            )
//        }
//        Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "Arrow") // Replace with an arrow icon if needed
//    }
//}
//
////@Preview
////@Composable
////fun ProfileActivityPreview() {
////    ProfileActivity()
////}


package com.example.foodpanda

import android.content.Context
import android.content.Intent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.firebase.auth.FirebaseAuth

@Composable
fun ProfileActivity(context: Context = LocalContext.current) {
    val insets = WindowInsets.systemBars.asPaddingValues()
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFCE4EC))
            .padding(20.dp)
            .padding(top = insets.calculateTopPadding())
            .padding(bottom = 70.dp)
            .verticalScroll(scrollState)
    ) {
        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Account",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "Shopping Cart"
            )
        }

        // User Profile Section
        Column(modifier = Modifier.padding(vertical = 16.dp)) {
            Text(
                text = "Aqdas",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
            TextButton(
                onClick = {
                    val intent = Intent(context, ProfileFormActivity::class.java)
                    context.startActivity(intent)
                },
                colors = ButtonDefaults.textButtonColors(contentColor = Color.Gray)
            ) {
                Text(text = "View profile")
            }
        }

        // Interactive Profile Cards
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ProfileCardItem("Orders", Icons.Default.ShoppingCart) {
                // Handle "Orders" click
            }
            ProfileCardItem("Favourites", Icons.Default.Favorite) {
                // Handle "Favourites" click
            }
            ProfileCardItem("Addresses", Icons.Default.LocationOn) {
                // Handle "Addresses" click
            }
        }

        // Pandapay Credit Section
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Pandapay Credit")
                Text(text = "Rs. 0.00", fontWeight = FontWeight.Bold)
            }
        }

        // Perks Section
        Text(
            text = "Perks for you",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        ProfilePerksItem("Become a pro", Icons.Default.Star)
        ProfilePerksItem("panda rewards", Icons.Default.FavoriteBorder)
        ProfilePerksItem("Vouchers", Icons.Default.Star)
        ProfilePerksItem("Invite friends", Icons.Default.Star)

        // General Section
        Text(
            text = "General",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        ProfileGeneralItem("Help center", Icons.Default.Build)
        ProfileGeneralItem("foodpanda for business", Icons.Default.Call)
        ProfileGeneralItem("Terms & policies", Icons.Default.Build)

        // Log out Button
        Button(
            onClick = {
                FirebaseAuth.getInstance().signOut()
                val intent = Intent(context, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                context.startActivity(intent)

            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            shape = RoundedCornerShape(50)
        ) {
            Text(text = "Log out")
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun ProfileCardItem(label: String, icon: androidx.compose.ui.graphics.vector.ImageVector, onClick: () -> Unit) {
    var isSelected by remember { mutableStateOf(false) }
    val backgroundColor by animateColorAsState(if (isSelected) Color(0xFFFFCCBC) else Color.White, tween(durationMillis = 500))
    val elevation by animateDpAsState(if (isSelected) 8.dp else 2.dp, tween(durationMillis = 500))

    Card(

        modifier = Modifier
            .padding(4.dp)
            .clickable {
                isSelected = !isSelected
                onClick()
            },

    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(imageVector = icon, contentDescription = label)
            Text(text = label)
        }
    }
}

@Composable
fun ProfilePerksItem(label: String, icon: androidx.compose.ui.graphics.vector.ImageVector) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { /* Handle click */ },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = icon, contentDescription = label, modifier = Modifier.size(24.dp))
            Text(text = label, modifier = Modifier.padding(start = 16.dp))
        }
        Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "Arrow")
    }
}

@Composable
fun ProfileGeneralItem(label: String, icon: androidx.compose.ui.graphics.vector.ImageVector) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { /* Handle click */ },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = icon, contentDescription = label, modifier = Modifier.size(24.dp))
            Text(text = label, modifier = Modifier.padding(start = 16.dp))
        }
        Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "Arrow")
    }
}

@Preview
@Composable
fun ProfileActivityPreview() {
    ProfileActivity()
}
