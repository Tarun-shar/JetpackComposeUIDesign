package com.example.learnjetpackcomposeui.UiDesigns.FoodMenuApp


import com.example.learnjetpackcomposeui.R
import com.example.learnjetpackcomposeui.UiDesigns.FoodMenuApp.model.PopularItemModel
import com.example.learnjetpackcomposeui.UiDesigns.FoodMenuApp.model.SuggestedItemModel

object FoodData {

    val popularItemList = listOf(
        PopularItemModel(0, R.drawable.photo1jpg, "Cheese Burger", R.drawable.baseline_star_24, "4.5"),
        PopularItemModel(1, R.drawable.photo1jpg, "Veg Pizza", R.drawable.baseline_star_24, "4.2"),
        PopularItemModel(2, R.drawable.photo1jpg, "Cold Drink", R.drawable.baseline_star_24, "4.1"),
        PopularItemModel(3, R.drawable.photo1jpg, "French Fries", R.drawable.baseline_star_24, "4.7")
    )

    val suggestedItemList = listOf(
        SuggestedItemModel(0, R.drawable.photo1jpg, "Burger + Fries + Drink", R.drawable.baseline_star_24, "4.5"),
        SuggestedItemModel(1, R.drawable.photo1jpg, "Pizza Combo", R.drawable.baseline_star_24, "4.3"),
        SuggestedItemModel(2, R.drawable.photo1jpg, "Dessert Special", R.drawable.baseline_star_24, "4.8"),
        SuggestedItemModel(3, R.drawable.photo1jpg, "Burger + Fries + Drink", R.drawable.baseline_star_24, "4.5"),
        SuggestedItemModel(4, R.drawable.photo1jpg, "Pizza Combo", R.drawable.baseline_star_24, "4.3"),
        SuggestedItemModel(5, R.drawable.photo1jpg, "Dessert Special", R.drawable.baseline_star_24, "4.8")
    )

    val allItemList = listOf(
        PopularItemModel(0,R.drawable.photo1jpg, "Cheese Burger", R.drawable.baseline_star_24, "4.5"),
        PopularItemModel(1,R.drawable.photo1jpg, "Cheese Burger", R.drawable.baseline_star_24, "4.5"),
        PopularItemModel(2,R.drawable.photo1jpg, "Cheese Burger", R.drawable.baseline_star_24, "4.5"),
        PopularItemModel(3,R.drawable.photo1jpg, "Cheese Burger", R.drawable.baseline_star_24, "4.5"),
        PopularItemModel(4,R.drawable.photo1jpg, "Cheese Burger", R.drawable.baseline_star_24, "4.5"),
        PopularItemModel(5,R.drawable.photo1jpg, "Cheese Burger", R.drawable.baseline_star_24, "4.5"),
        PopularItemModel(6,R.drawable.photo1jpg, "Cheese Burger", R.drawable.baseline_star_24, "4.5"),
        PopularItemModel(7,R.drawable.photo1jpg, "Cheese Burger", R.drawable.baseline_star_24, "4.5"),
        PopularItemModel(8,R.drawable.photo1jpg, "Cheese Burger", R.drawable.baseline_star_24, "4.5"),
        PopularItemModel(9,R.drawable.photo1jpg, "Cheese Burger", R.drawable.baseline_star_24, "4.5"),
        PopularItemModel(10,R.drawable.photo1jpg, "Cheese Burger", R.drawable.baseline_star_24, "4.5"),

        )

    val cartItemList = listOf(
        PopularItemModel(0, R.drawable.photo1jpg, "Cheese Burger", R.drawable.baseline_star_24, "Rs. 412"),
        PopularItemModel(1, R.drawable.photo1jpg, "Veg Pizza", R.drawable.baseline_star_24, "Rs. 310"),
        PopularItemModel(2, R.drawable.photo1jpg, "Cold Drink", R.drawable.baseline_star_24, "Rs. 65"),
        PopularItemModel(3, R.drawable.photo1jpg, "French Fries", R.drawable.baseline_star_24, "Rs. 200"),
        PopularItemModel(4, R.drawable.photo1jpg, "Cheese Burger", R.drawable.baseline_star_24, "Rs. 412"),
    /*    PopularItemModel(5, R.drawable.photo1jpg, "Veg Pizza", R.drawable.baseline_star_24, "Rs. 310"),
        PopularItemModel(6, R.drawable.photo1jpg, "Cold Drink", R.drawable.baseline_star_24, "Rs. 65"),
        PopularItemModel(7, R.drawable.photo1jpg, "French Fries", R.drawable.baseline_star_24, "Rs. 200")*/
    )
}
