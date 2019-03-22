package com.example.daria_selenskaya_shop
import kotlinx.serialization.Serializable

@Serializable
    data class Product(
        val name: String,
        val ageGender: String,
        val imageUrl: String
    )