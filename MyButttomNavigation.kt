package com.example.navhomework006bottomnavigation



import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.material.*


@Composable
fun MyBottomNavigation(navController: NavController){
    val destonationList = listOf<Destinations>( Login , welcome)
    val selectedIndex = rememberSaveable{
        mutableStateOf(0)
    }
    BottomNavigation() {
        destonationList.forEachIndexed { index, destinations ->
            BottomNavigationItem(
                label = {Text(text = destinations.title )},
                icon = { Icon(imageVector = destinations.icon, contentDescription = destinations.title) },
                selected = index==selectedIndex.value ,
                onClick = {
                    selectedIndex.value = index
                    navController.navigate(destonationList[index].Route){
                        popUpTo(Login.Route)
                        launchSingleTop = true
                    }
                })
        }
    }
}
