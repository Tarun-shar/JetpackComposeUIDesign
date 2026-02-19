package com.example.learnjetpackcomposeui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.learnjetpackcomposeui.UiDesigns.FoodMenuApp.CheckoutScreen
import com.example.learnjetpackcomposeui.UiDesigns.FoodMenuApp.DashboardScreen
import com.example.learnjetpackcomposeui.UiDesigns.FoodMenuApp.FoodDetailScreen
import com.example.learnjetpackcomposeui.UiDesigns.FoodMenuApp.HomeScreen
import com.example.learnjetpackcomposeui.UiDesigns.FoodMenuApp.SeeAllItems
import com.example.learnjetpackcomposeui.UiDesigns.SimpleLoginRegisterApp.LoginScreen
import com.example.learnjetpackcomposeui.UiDesigns.SimpleLoginRegisterApp.RegisterScreen
import com.example.learnjetpackcomposeui.UiDesigns.SimpleLoginRegisterApp.ResetPasswordScreen
import com.example.learnjetpackcomposeui.UiDesigns.SimpleLoginRegisterApp.StartScreen
import com.example.learnjetpackcomposeui.UiDesigns.SimpleLoginRegisterApp.VerifyCodeScreen

@Composable
fun AppNavHost(
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = "start"
    ) {

        // --- Start Screen ---
        composable("start") {
            StartScreen(navController = navController)
        }

        // --- Login Screen ---
        composable("login") {
            LoginScreen(navController = navController)
        }

        // --- Register Screen ---
        composable("Signup") {
            RegisterScreen(navController = navController)
        }

        // --- ResetPasswordScreen ---
        composable("ResetPasswordScreen") {
            ResetPasswordScreen(navController = navController)
        }

        // --- VerifyCodeScreen ---
        composable("VerifyCodeScreen") {
            VerifyCodeScreen(navController = navController)
        }

        // --- Dashboard Screen ---
        composable("dashboard") {
            DashboardScreen(navController = navController)
        }

        // --- Home Screen ---
        composable("home") {
            HomeScreen(navController = navController)
        }

        // --- Food Detail Screen ---
        composable("foodDetailScreen") {
            CheckoutScreen(navController = navController)
        }

        // --- ViewAll Screen ---
        composable(
            route = "viewAllScreen/{title}",
            arguments = listOf(
                navArgument("title") { type = NavType.StringType }
            )
        ) { backStackEntry ->

            val name = backStackEntry.arguments?.getString("title") ?: ""

            SeeAllItems(navController = navController,name)
        }


        // --- Food Detail Screen ---
        composable(
            route = "foodDetailScreen/{itemId}",
            arguments = listOf(
                navArgument("itemId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->

            val itemId = backStackEntry.arguments?.getInt("itemId")

            FoodDetailScreen(navController,itemId)
        }

    }
}
