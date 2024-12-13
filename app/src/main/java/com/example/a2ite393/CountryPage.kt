package com.example.a2ite393

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.FrameLayout
import android.widget.ImageSwitcher
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CountryPage : AppCompatActivity() {

    private lateinit var imageSwitcher: ImageSwitcher
    private val images = arrayOf(
        R.drawable.aishit,
        R.drawable.boat,
        R.drawable.building,
        R.drawable.landscape
    )
    private var currentIndex = 0
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_country_page)

        val countryList = listOf(
            Country("China", "Beijing", R.drawable.china),
            Country("India", "New Delhi", R.drawable.india),
            Country("Japan", "Tokyo", R.drawable.japan),
            Country("South Korea", "Seoul", R.drawable.southkorea),
            Country("Indonesia", "Jakarta", R.drawable.indonesia),
            Country("Saudi Arabia", "Riyadh", R.drawable.saudiaarabia),
            Country("Turkey", "Ankara", R.drawable.turkey),
            Country("United Arab Emirates (UAE)", "Abu Dhabi", R.drawable.uae),
            Country("Pakistan", "Islamabad", R.drawable.pakistan),
            Country("Bangladesh", "Dhaka", R.drawable.bangladesh),
            Country("Vietnam", "Hanoi", R.drawable.vietnam),
            Country("Philippines", "Manila", R.drawable.philippines),
            Country("Thailand", "Bangkok", R.drawable.thailand),
            Country("Malaysia", "Kuala Lumpur", R.drawable.malaysia),
            Country("Iran", "Tehran", R.drawable.iran),
            Country("Israel", "Jerusalem", R.drawable.israel),
            Country("Qatar", "Doha", R.drawable.qatar),
            Country("Kazakhstan", "Astana", R.drawable.kazakhstan),
            Country("Singapore", "Singapore", R.drawable.singapore),
            Country("Iraq", "Baghdad", R.drawable.iraq)
        )

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = CountryAdapter(countryList)
        recyclerView.adapter = adapter

        imageSwitcher = findViewById(R.id.imageSwitcher)
        imageSwitcher.setFactory {
            val imageView = ImageView(this)
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            imageView.layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT
            )
            imageView
        }


        startImageCarousel()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun startImageCarousel() {
        handler.post(object : Runnable {
            override fun run() {
                imageSwitcher.setImageResource(images[currentIndex])
                currentIndex = (currentIndex + 1) % images.size
                handler.postDelayed(this, 3000)
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }
}
