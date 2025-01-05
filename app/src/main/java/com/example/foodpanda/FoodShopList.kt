package com.example.foodpanda


import com.example.foodpanda.Shop
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun FoodShopCard(shop: Shop, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .clickable { onClick() }
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = shop.imageResource),
            contentDescription = shop.name,
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxHeight()
        ) {
            Text(
                text = shop.name,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = shop.location,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}

@Composable
fun FoodShopList() {
    val shops = listOf(
        Shop("Pizza Place", R.drawable.image3, "Downtown"),
        Shop("Biryani Corner", R.drawable.image3, "East Street"),
        Shop("Burger Hub", R.drawable.image3, "Main Avenue"),
        Shop("Pasta House", R.drawable.image3, "West End"),
        Shop("Salad Stop", R.drawable.image3, "Green Market")
    )

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(shops) {item->FullWidthShopCard(item) { }}
//        items(shops) { item ->
//            FullWidthFoodCard(item) {
//                // Handle click event (e.g., navigate to detail screen)
//            }
//        }

    }
}

@Composable
fun FullWidthShopCard(item: Shop, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .clickable { onClick() }
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = item.imageResource),
            contentDescription = item.name,
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxHeight()
        ) {
            Text(
                text = item.name,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Delicious and fresh",
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}

