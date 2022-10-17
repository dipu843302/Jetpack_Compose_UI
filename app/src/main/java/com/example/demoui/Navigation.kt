package com.example.demoui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.StatusView.route) {
        composable(route = Screen.StatusView.route) {
            StatusView(true, "I am Available", "I can take calls", navController)
        }
        composable(route = Screen.StatusMeeting.route) {
            StatusBreak("In a Meeting", "Further Notice", "Next Hour", "Next 2 Hours", "Custom", navController)
        }
        composable(route = Screen.StatusLunch.route) {
            StatusBreak("Lunch", "15 Minutes", "30 Minutes", "Next Hour", "Custom", navController)
        }
        composable(route = Screen.StatusVacation.route) {
            StatusBreak("Vacation", "1 Day", "2 Days", "1 Week", "Custom", navController)
        }
        composable(route = Screen.StatusCustom.route) {
            StatusBreak("", "Further Notice", "Next Hour", "Next 2 Hours", "Custom", navController)
        }
    }
}