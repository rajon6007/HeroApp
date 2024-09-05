package com.example.heroapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.heroapp.Adapter.HeroAdapter
import com.example.heroapp.Model.Hero
import com.example.heroapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var heroAdapter: HeroAdapter
    val hero = ArrayList<Hero>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.heroRv.layoutManager = LinearLayoutManager(this)

        hero.add(Hero("Vijay Thalapathi","GOAT","$14M",R.drawable.vijay))
        hero.add(Hero("Allu Arjun","Pushpa","$15M",R.drawable.allu))
        hero.add(Hero("Dhanush","Maari","$20M",R.drawable.dhanush))
        hero.add(Hero("Mahesh Babu","Srimanthudu","$16M",R.drawable.mahesh))
        hero.add(Hero("Actor Nani","Syam Singha Roy","$14M",R.drawable.nani))
        hero.add(Hero("NTR jr","RRR","$30M",R.drawable.ntr))
        hero.add(Hero("Probhas","Kalki","$20M",R.drawable.probhas))
        hero.add(Hero("Ram Charan","RRR","$14M",R.drawable.ramc))
        hero.add(Hero("Ram Potthineni","Ismart Shankar","$14M",R.drawable.rapo))
        hero.add(Hero("Suriya  ","Singhum","$14M",R.drawable.suriya))
        hero.add(Hero("vijay Devorkonda ","Geeta Givinda","$14M",R.drawable.vijayd))
        hero.add(Hero("Yash","KGF 2","$14M",R.drawable.yash))

        heroAdapter = HeroAdapter(hero)
        binding.heroRv.adapter = heroAdapter

        heroAdapter.onClick={
            val intent =Intent(this, DetailsActivity::class.java)
            intent.putExtra("name",it.heroName)
            intent.putExtra("title",it.filmTitle)
            intent.putExtra("fees",it.heroFees)
            intent.putExtra("image",it.heroImg)
            startActivity(intent)

        }
        binding.addBtn.setOnClickListener {

        }
        val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                hero.removeAt(viewHolder.adapterPosition)
                heroAdapter.notifyItemRemoved(viewHolder.adapterPosition)
            }
        })

        itemTouchHelper.attachToRecyclerView(binding.heroRv)



    }



    }
