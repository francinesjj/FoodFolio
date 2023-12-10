package com.example.appdevalt

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appdevalt.databinding.ActivityHomepageBinding

class Homepage : AppCompatActivity() {

    private lateinit var binding: ActivityHomepageBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var recipeAdapter: RecipeAdapter
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomepageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val loggedInUserId = getCurrentUserID()

        databaseHelper = DatabaseHelper(this)
        sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val recipes = databaseHelper.getAllRecipes(loggedInUserId)

        recipeAdapter = RecipeAdapter(recipes)
        binding.recipeRecycler.layoutManager = LinearLayoutManager(this)
        binding.recipeRecycler.adapter = recipeAdapter

        binding.btnAddRecipe.setOnClickListener {
            val i = Intent(this, AddRecipe::class.java)
            startActivity(i)
        }

        val btnLogout: ImageView = findViewById(R.id.btnLogout)
        btnLogout.setOnClickListener {

            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()

            val intent = Intent(this, LogIn::class.java)
            startActivity(intent)
            Toast.makeText(this, "Log Out Successful", Toast.LENGTH_LONG).show()
            finish()
        }
    }
   /*refreshes app, para magreflect agad sa recycler ung bagong recipe*/
   override fun onResume() {
       super.onResume()
       val loggedInUserId = getCurrentUserID()
       val recipes = databaseHelper.getAllRecipes(loggedInUserId)
       recipeAdapter.refreshData(recipes)
   }

    private fun getCurrentUserID(): Int {
        val sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        return sharedPreferences.getInt("USER_ID", -1)
    }


}