package com.example.foodpanda





import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


data class SliderItem(val title: String, val imageResource: Int)

@Composable
fun HomeScreen(context: Context) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
//        HeaderSection()
        Spacer(modifier = Modifier.height(16.dp))
        HorizontalIconSlider()
        Spacer(modifier = Modifier.height(16.dp))
        HorizontalCardSlider { selectedItem ->
            val intent = Intent(context, DetailActivity::class.java).apply {
                putExtra("title", selectedItem.title)
                putExtra("imageResource", selectedItem.imageResource)
            }
            context.startActivity(intent)
        }
        Spacer(modifier = Modifier.height(16.dp))
        FastDeliverySection()
        Spacer(modifier = Modifier.height(16.dp))
        FoodList()
    }
}



@Composable
fun HorizontalIconSlider() {
    val iconItems = listOf(
        SliderItem("Offers", R.drawable.offer_icon),
        SliderItem("Pandamart", R.drawable.pandamart_icon),
        SliderItem("Pick-up", R.drawable.pickup_icon),
        SliderItem("Pandago", R.drawable.pandamart_icon)
    )

    LazyRow(
        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(iconItems) { item ->
            IconCard(item) { /* Handle Click */ }
        }
    }
}

@Composable
fun IconCard(item: SliderItem, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(8.dp)
            .clickable { onClick() }
    ) {
        Image(
            painter = painterResource(id = item.imageResource),
            contentDescription = item.title,
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = item.title, fontWeight = FontWeight.SemiBold, fontSize = 12.sp)
    }
}

@Composable
fun FoodCard(item: SliderItem, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(100.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable { onClick() }
    ) {
        Image(
            painter = painterResource(id = item.imageResource),
            contentDescription = item.title,
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = item.title,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )
    }
}

@Composable
fun HorizontalCardSlider(onItemClick: (SliderItem) -> Unit) {
    val itemsList = listOf(
        SliderItem("Pizza", R.drawable.image1),
        SliderItem("Biryani", R.drawable.image2),
        SliderItem("Burgers", R.drawable.image3),
        SliderItem("Pasta", R.drawable.image4),
        SliderItem("Salad", R.drawable.image5)
    )

    LazyRow(
        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(itemsList) { item ->
            FoodCard(item) {
                onItemClick(item)
            }
        }
    }
}

@Composable
fun FastDeliverySection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFDEFEF), shape = RoundedCornerShape(16.dp))
            .padding(16.dp)
    ) {
        Text(
            text = "Fast Delivery",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Get 20% off: Use code mc20",
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Free delivery on selected items!",
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Save 25%",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.Red
            )
            Text(
                text = "Hurry! Limited time offers",
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp
            )
        }
    }
}



@Composable
fun FullWidthFoodCard(item: SliderItem, onClick: () -> Unit) {
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
            contentDescription = item.title,
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
                text = item.title,
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


@Composable
fun FoodList() {
    val foodItems = listOf(
        SliderItem("Pizza", R.drawable.image1),
        SliderItem("Biryani", R.drawable.image2),
        SliderItem("Burgers", R.drawable.image3),
        SliderItem("Pasta", R.drawable.image4),
        SliderItem("Salad", R.drawable.image5)
    )

    LazyColumn(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(foodItems) { item ->
            FullWidthFoodCard(item) {
                // Handle click event (e.g., navigate to detail screen)
            }
        }
    }
}
