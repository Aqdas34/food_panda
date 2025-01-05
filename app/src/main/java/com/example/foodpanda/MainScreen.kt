package com.example.foodpanda


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import java.nio.channels.Selector


@Composable
fun MainScreen(modifier: Modifier = Modifier)
{
    val navItemList = listOf(
        NavItem("Home",Icons.Default.Home),
        NavItem("Shops",Icons.Default.ShoppingCart),
        NavItem("Search",Icons.Default.Search),
        NavItem("Account",Icons.Default.AccountCircle),
        NavItem("Add Food", Icons.Default.Add)
    )
    var selectedIndex by remember { mutableIntStateOf(0) }
    Scaffold(
        modifier= Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
             navItemList.forEachIndexed { index,navItem ->
                 NavigationBarItem(
                     selected = selectedIndex == index,
                     onClick = {
                         selectedIndex = index
                     },
                     icon={
                         Icon(imageVector = navItem.icon, contentDescription = "Icon")
                     },
                     label = {
                         Text(text=navItem.label)
                     }
                 )
             }
            }
        }
        ) { innerPadding->
    ContentScreen(modifier = Modifier.padding(innerPadding),selectedIndex
    )


    }
}


@Composable
fun ContentScreen(modifier: Modifier = Modifier, selectedIndex: Int)
{
when(selectedIndex)
{
    0->HomeScreen(context = LocalContext.current)
    1->FoodShopList()
    2->PopularSearchPage(context = LocalContext.current)
    3->ProfileActivity(context = LocalContext.current)
    4 -> AddFoodItemScreen(onSubmit = { foodItem ->
        // Handle the added food item (e.g., save to a list or database)
        println("Food Item Added: $foodItem")
    })
}

}
