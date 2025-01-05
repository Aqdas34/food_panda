package com.example.foodpanda

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodpanda.ui.theme.FoodPandaTheme
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.initialize



data class BottomNavigtionItem(
    val  title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        val items = listOf(
            BottomNavigtionItem(
                title="Home",
                selectedIcon = Icons.Filled.Home,
                unselectedIcon = Icons.Default.Home
            ),
            BottomNavigtionItem(
                title="Shops",
                selectedIcon = Icons.Filled.ShoppingCart,
                unselectedIcon = Icons.Default.ShoppingCart
            ),
            BottomNavigtionItem(
                title="Search",
                selectedIcon = Icons.Filled.Search,
                unselectedIcon = Icons.Default.Search
            ),
            BottomNavigtionItem(
                title="Account",
                selectedIcon = Icons.Filled.AccountCircle,
                unselectedIcon = Icons.Default.AccountCircle
            ),
            BottomNavigtionItem(
                title = "Add Food",
                selectedIcon = Icons.Filled.Add, // Use an appropriate icon for "Add Food"
                unselectedIcon = Icons.Default.Add // Adjust as necessary
            )

        )


        setContent {
            Firebase.initialize(this)

            val user = remember { FirebaseAuth.getInstance().currentUser }

            if (user != null) {
                // User is logged in, show HomePage
                MainScreen()
            } else {
                // User is not logged in, show LoginScreen
                LoginScreen()
            }
//            MainScreen()

//            LoginScreen()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FoodPandaTheme {
        Greeting("Android")
    }
}




