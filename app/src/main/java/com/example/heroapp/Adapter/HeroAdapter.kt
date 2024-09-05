package com.example.heroapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.heroapp.Model.Hero
import com.example.heroapp.databinding.ListActivityBinding


class HeroAdapter(private val heroList:ArrayList<Hero>):RecyclerView.Adapter<HeroAdapter.HeroViewHolder>() {
    var onClick: ((Hero) -> Unit)? = null

    class HeroViewHolder(val binding: ListActivityBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):HeroViewHolder {

        val view = ListActivityBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)
        return HeroViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeroAdapter.HeroViewHolder, position: Int) {
        holder.binding.apply {
            nameid.text = heroList[position].heroName
            titleid.text = "Movie Name: " + heroList[position].filmTitle
            feesid.text = "Film per fees: " + heroList[position].heroFees
            imageid.setImageResource(heroList[position].heroImg)
        }
        holder.itemView.setOnClickListener {
            onClick?.invoke(heroList[position])
        }
        holder.itemView.setOnClickListener {
            AlertDialog.Builder(holder.itemView.context)
                .setTitle("Romove hero")
                .setMessage("Are you sure you want to remove?")
                .setPositiveButton("Yes") { _, _ ->
                    heroList.removeAt(position)
                    notifyItemMoved(position, position)
                }
                .setNegativeButton("No", null)
                .show()
            true
        }
    }


    override fun getItemCount(): Int {
        return heroList.size
    }
}