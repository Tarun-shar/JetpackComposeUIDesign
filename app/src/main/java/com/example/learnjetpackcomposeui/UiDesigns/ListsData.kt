package com.example.learnjetpackcomposeui.UiDesigns

import com.example.learnjetpackcomposeui.R
import com.example.learnjetpackcomposeui.UiDesigns.FoodMenuApp.model.PopularItemModel
import com.example.learnjetpackcomposeui.UiDesigns.FoodMenuApp.model.SuggestedItemModel
import com.example.learnjetpackcomposeui.UiDesigns.TravelBookingUI.model.PlacesModel

object ListsData {

    val categories = listOf(
        "All", "Pizza", "Burger", "Drinks", "Dessert", "Chinese"
    )
    val popularItemList = listOf(
        PopularItemModel(
            0,
            R.drawable.photo1jpg,
            "Cheese Burger",
            R.drawable.baseline_star_24,
            "4.5"
        ),
        PopularItemModel(1, R.drawable.photo1jpg, "Veg Pizza", R.drawable.baseline_star_24, "4.2"),
        PopularItemModel(2, R.drawable.photo1jpg, "Cold Drink", R.drawable.baseline_star_24, "4.1"),
        PopularItemModel(
            3,
            R.drawable.photo1jpg,
            "French Fries",
            R.drawable.baseline_star_24,
            "4.7"
        )
    )

    val suggestedItemList = listOf(
        SuggestedItemModel(
            0,
            R.drawable.photo1jpg,
            "Burger + Fries + Drink",
            R.drawable.baseline_star_24,
            "4.5"
        ),
        SuggestedItemModel(
            1,
            R.drawable.photo1jpg,
            "Pizza Combo",
            R.drawable.baseline_star_24,
            "4.3"
        ),
        SuggestedItemModel(
            2,
            R.drawable.photo1jpg,
            "Dessert Special",
            R.drawable.baseline_star_24,
            "4.8"
        ),
        SuggestedItemModel(
            3,
            R.drawable.photo1jpg,
            "Burger + Fries + Drink",
            R.drawable.baseline_star_24,
            "4.5"
        ),
        SuggestedItemModel(
            4,
            R.drawable.photo1jpg,
            "Pizza Combo",
            R.drawable.baseline_star_24,
            "4.3"
        ),
        SuggestedItemModel(
            5,
            R.drawable.photo1jpg,
            "Dessert Special",
            R.drawable.baseline_star_24,
            "4.8"
        )
    )

    val allItemList = listOf(
        PopularItemModel(
            0,
            R.drawable.photo1jpg,
            "Cheese Burger",
            R.drawable.baseline_star_24,
            "4.5"
        ),
        PopularItemModel(
            1,
            R.drawable.photo1jpg,
            "Cheese Burger",
            R.drawable.baseline_star_24,
            "4.5"
        ),
        PopularItemModel(
            2,
            R.drawable.photo1jpg,
            "Cheese Burger",
            R.drawable.baseline_star_24,
            "4.5"
        ),
        PopularItemModel(
            3,
            R.drawable.photo1jpg,
            "Cheese Burger",
            R.drawable.baseline_star_24,
            "4.5"
        ),
        PopularItemModel(
            4,
            R.drawable.photo1jpg,
            "Cheese Burger",
            R.drawable.baseline_star_24,
            "4.5"
        ),
        PopularItemModel(
            5,
            R.drawable.photo1jpg,
            "Cheese Burger",
            R.drawable.baseline_star_24,
            "4.5"
        ),
        PopularItemModel(
            6,
            R.drawable.photo1jpg,
            "Cheese Burger",
            R.drawable.baseline_star_24,
            "4.5"
        ),
        PopularItemModel(
            7,
            R.drawable.photo1jpg,
            "Cheese Burger",
            R.drawable.baseline_star_24,
            "4.5"
        ),
        PopularItemModel(
            8,
            R.drawable.photo1jpg,
            "Cheese Burger",
            R.drawable.baseline_star_24,
            "4.5"
        ),
        PopularItemModel(
            9,
            R.drawable.photo1jpg,
            "Cheese Burger",
            R.drawable.baseline_star_24,
            "4.5"
        ),
        PopularItemModel(
            10,
            R.drawable.photo1jpg,
            "Cheese Burger",
            R.drawable.baseline_star_24,
            "4.5"
        ),

        )

    val cartItemList = listOf(
        PopularItemModel(
            0,
            R.drawable.photo1jpg,
            "Cheese Burger",
            R.drawable.baseline_star_24,
            "Rs. 412"
        ),
        PopularItemModel(
            1,
            R.drawable.photo1jpg,
            "Veg Pizza",
            R.drawable.baseline_star_24,
            "Rs. 310"
        ),
        PopularItemModel(
            2,
            R.drawable.photo1jpg,
            "Cold Drink",
            R.drawable.baseline_star_24,
            "Rs. 65"
        ),
        PopularItemModel(
            3,
            R.drawable.photo1jpg,
            "French Fries",
            R.drawable.baseline_star_24,
            "Rs. 200"
        ),
        PopularItemModel(
            4,
            R.drawable.photo1jpg,
            "Cheese Burger",
            R.drawable.baseline_star_24,
            "Rs. 412"
        ),
    /*    PopularItemModel(5, R.drawable.photo1jpg, "Veg Pizza", R.drawable.baseline_star_24, "Rs. 310"),
        PopularItemModel(6, R.drawable.photo1jpg, "Cold Drink", R.drawable.baseline_star_24, "Rs. 65"),
        PopularItemModel(7, R.drawable.photo1jpg, "French Fries", R.drawable.baseline_star_24, "Rs. 200")*/
    )

    val placesList = listOf(
        PlacesModel(
            0,
            R.drawable.tajmahal,
            "Taj Mahal",
            "India",
            R.drawable.baseline_star_24,
            "4.2",
            "2 Days - 3 Nights",
            "$900"
        ),
        PlacesModel(
            1,
            R.drawable.maldives,
            "Maldives",
            "Maldives",
            R.drawable.baseline_star_24,
            "4.5",
            "4 Days - 5 Nights",
            "$1400"
        ),
        PlacesModel(
            2,
            R.drawable.paris,
            "Paris",
            "France",
            R.drawable.baseline_star_24,
            "4.0",
            "5 Days - 6 Nights",
            "$5000"
        ),
        PlacesModel(
            3,
            R.drawable.bali,
            "Bali",
            "Indonesia",
            R.drawable.baseline_star_24,
            "4.4",
            "3 Days - 4 Nights",
            "$1800"
        ),
        PlacesModel(
            4,
            R.drawable.delhi,
            "Delhi",
            "India",
            R.drawable.baseline_star_24,
            "4.2",
            "2 Days - 3 Nights",
            "$1200"
        ),
        PlacesModel(
            5,
            R.drawable.bali,
            "Bali",
            "Indonesia",
            R.drawable.baseline_star_24,
            "4.4",
            "3 Days - 4 Nights",
            "$1800"
        ),
        PlacesModel(
            6,
            R.drawable.delhi,
            "Delhi",
            "India",
            R.drawable.baseline_star_24,
            "4.2",
            "2 Days - 3 Nights",
            "$1200"
        ),
        PlacesModel(
            7,
            R.drawable.bali,
            "Bali",
            "Indonesia",
            R.drawable.baseline_star_24,
            "4.4",
            "3 Days - 4 Nights",
            "$1800"
        ),
        PlacesModel(
            8,
            R.drawable.delhi,
            "Delhi",
            "India",
            R.drawable.baseline_star_24,
            "4.2",
            "2 Days - 3 Nights",
            "$1200"
        )

    )

    val placeCategories = listOf(
        "All","Popular","Mountains","Beach","City","Hill Station","Desert"
    )

    val bookingsCategory = listOf(
        "Upcoming", "Completed", "Cancelled"
    )


    val travelCategory = listOf(
        "Flight", "Travel", "Hotel"
    )
}