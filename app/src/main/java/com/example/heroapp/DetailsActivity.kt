package com.example.heroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.heroapp.databinding.ActivityDetailsBinding

class DetailsActivity: AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val name = intent.getStringExtra("Name")
        val title = intent.getStringExtra("Title")
        val fees = intent.getStringExtra("Fees")
        val img = intent.getIntExtra("Image",0)

        binding.apply {
            nameid.text = name
            titleid.text = title
            feesid.text = fees
            image.setImageResource(img)

        }
    }
}