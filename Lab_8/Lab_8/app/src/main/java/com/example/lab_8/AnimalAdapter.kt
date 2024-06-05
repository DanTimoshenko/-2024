package com.example.lab_8

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lab_8.databinding.RecycleViewBinding


class AnimalAdapter (private val items: List<Pair<String, String?>>,
                     private val onItemClick: (position: Int) -> Unit):
                    RecyclerView.Adapter<AnimalAdapter.AnimalHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalHolder {
        val binding = RecycleViewBinding.inflate(LayoutInflater.from(parent.context))
        return AnimalHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: AnimalHolder, position: Int) {
        val animalName = items[position]
        holder.bind(animalName.first, animalName.second)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class AnimalHolder(private val binding: RecycleViewBinding,
                       private val onItemClick: (position: Int) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {
            init {
                binding.animalButton.setOnClickListener {
                    onItemClick(adapterPosition)
                }
            }

            fun bind(animalName: String, imageUrl: String?) {
                Glide.with(binding.imageView)
                    .load(imageUrl)
                    .centerCrop()
                    .placeholder(binding.imageView.drawable)
                    .error(R.drawable.ic_launcher_background)
                    .fallback(R.drawable.ic_launcher_foreground)
                    .into(binding.imageView)
                binding.animalButton.text = animalName
        }
    }
}