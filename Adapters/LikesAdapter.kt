package com.example.practico3tindermo.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.practico3tindermo.Person
import com.example.practico3tindermo.databinding.ItemLikedPersonBinding

class LikesAdapter(private val likedPeople: List<Person>) :
    RecyclerView.Adapter<LikesAdapter.LikesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LikesViewHolder {
        val binding = ItemLikedPersonBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return LikesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LikesViewHolder, position: Int) {
        val person = likedPeople[position]
        holder.bind(person)
    }

    override fun getItemCount(): Int = likedPeople.size

    inner class LikesViewHolder(private val binding: ItemLikedPersonBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(person: Person) {
            binding.nameTextView.text = person.name
            // Cargar la primera imagen como foto de perfil
            val firstImage = person.imageResources.firstOrNull() ?: ""
            Glide.with(binding.profileImageView.context)
                .load(firstImage)
                .into(binding.profileImageView)
        }
    }
}
