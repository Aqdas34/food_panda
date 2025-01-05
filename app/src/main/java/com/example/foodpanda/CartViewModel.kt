package com.example.foodpanda

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

class CartViewModel {
    // This will hold the list of items in the cart
    val cartItems = mutableStateListOf<CartItem>()

    // Function to add an item to the cart
    fun addToCart(item: CartItem) {
        val existingItem = cartItems.find { it.title == item.title }
        if (existingItem != null) {
            // If item already exists, increment the quantity
            existingItem.quantity += 1
        } else {
            // Otherwise, add the item to the cart
            cartItems.add(item.copy(quantity = 1))
        }
    }
}
