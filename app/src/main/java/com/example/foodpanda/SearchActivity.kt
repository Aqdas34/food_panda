package com.example.foodpanda

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PopularSearchPage(context: Context) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.systemBars.asPaddingValues()) // Add padding for safe areas
            .padding(16.dp)
    ) {
        // Search bar
        SearchBar()

        Spacer(modifier = Modifier.height(24.dp))

        // Popular searches in Restaurants with updated food items
        PopularSearchSection(
            title = "Popular searches in Restaurants",
            items = listOf("Sushi", "Tacos", "Pasta", "Steak", "Ramen", "BBQ", "Seafood", "Salad"),
            onItemClick = { item ->
                showToast(context, "Clicked on $item")
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Popular searches in Shops with updated food items
        PopularSearchSection(
            title = "Popular searches in Shops",
            items = listOf("Ice Cream", "Soda", "Candy", "Chocolate", "Cookies", "Doughnuts", "Juice", "Granola"),
            onItemClick = { item ->
                showToast(context, "Clicked on $item")
            }
        )
    }
}

@Composable
fun SearchBar() {
    BasicTextField(
        value = "",
        onValueChange = {},
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color.LightGray),
        textStyle = TextStyle(fontSize = 16.sp),
        decorationBox = { innerTextField ->
            Box(modifier = Modifier.padding(start = 16.dp, top = 14.dp, bottom = 14.dp)) {
                innerTextField()
            }
        }
    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PopularSearchSection(title: String, items: List<String>, onItemClick: (String) -> Unit) {
    Column {
        Text(
            text = title,
            style = TextStyle(fontSize = 18.sp)
        )

        Spacer(modifier = Modifier.height(8.dp))

        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items.forEach { item ->
                SearchChip(text = item, onClick = { onItemClick(item) })
            }
        }
    }
}

@Composable
fun SearchChip(text: String, onClick: () -> Unit) {
    Surface(
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .clickable { onClick() }, // Make the chip clickable
        color = Color.LightGray
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            style = TextStyle(fontSize = 14.sp)
        )
    }
}

fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}
