package com.example.appdevalt

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecipeAdapter(private var recipes: List<Recipe>) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {
    class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.tvTitle)
        val categoryTextView: TextView = itemView.findViewById(R.id.tvCategory)
        val updateButton: ImageView = itemView.findViewById(R.id.updateButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recipe_item, parent, false)
        return RecipeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val currentRecipe = recipes[position]
        holder.titleTextView.text = currentRecipe.title
        holder.categoryTextView.text = currentRecipe.category

        holder.updateButton.setOnClickListener {
            val toUpdateRecipe = Intent(holder.itemView.context, UpdateRecipe::class.java)
            toUpdateRecipe.putExtra("recipeId", currentRecipe.id)
            holder.itemView.context.startActivity(toUpdateRecipe)
        }
    }

    fun refreshData(newRecipes: List<Recipe>) {
        recipes = newRecipes
        notifyDataSetChanged()
    }
    override fun getItemCount() = recipes.size
}