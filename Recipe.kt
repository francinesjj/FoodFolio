package com.example.appdevalt

data class Recipe(
    val id: Int,
    val userID: Int,
    val title: String,
    val category: String,
    val ingredients: String,
    val procedure: String
)
