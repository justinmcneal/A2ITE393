package com.example.a2ite393

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        recyclerView = findViewById(R.id.recyclerView)



        val countryList = listOf(
            Country("South Korea", R.drawable.sokor, "Seoul"),
            Country("Japan", R.drawable.jpn, "Tokyo"),
            Country("China", R.drawable.cn, "Beijing"),
            Country("Singapore", R.drawable.sg, "Singapore"),
            Country("Thailand", R.drawable.thai, "Bangkok"),
            Country("Indonesia", R.drawable.indo, "Jakarta"),
            Country("Philippines", R.drawable.ph, "Manila"),
            Country("Vietnam", R.drawable.viet, "Hanoi"),
            Country("Taiwan", R.drawable.taiwan, "Taipei"),
            Country("India", R.drawable.india, "New Delhi"),
            Country("Bangladesh", R.drawable.bdesh, "Dhaka"),
            Country("Pakistan", R.drawable.pkstan, "Islamabad"),
            Country("North Korea", R.drawable.nokor, "Pyongyang"),
            Country("Russia", R.drawable.russia, "Moscow"),
            Country("Iran", R.drawable.iran, "Tehran"),
            Country("Iraq", R.drawable.iraq, "Baghdad"),
            Country("Turkey", R.drawable.turk, "Ankara"),
            Country("Kazakhstan", R.drawable.kazakh, "Astana"),
            Country("Israel", R.drawable.israel, "Jerusalem"),
            Country("Malaysia", R.drawable.malay, "Kuala Lumpur")
        )

        val adapter = CountryAdapter(countryList)

        recyclerView.adapter = adapter

        recyclerView.layoutManager = LinearLayoutManager(this)

    }
}