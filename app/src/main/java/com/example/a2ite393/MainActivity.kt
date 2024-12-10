package com.example.a2ite393

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)


        recyclerView.layoutManager = LinearLayoutManager(this)


        val dataList = arrayListOf(
            recyclerData("Bangladesh", R.drawable.bangladesh, "Dhaka"),
            recyclerData("South Korea", R.drawable.southkorea, "Seoul"),
            recyclerData("China", R.drawable.china, "Beijing"),
            recyclerData("Philippines", R.drawable.ph, "Manila"),
            recyclerData("Japan", R.drawable.japan, "Tokyo"),
            recyclerData("Saudi Arabia", R.drawable.ssaudi, "Riyadh"),
            recyclerData("Pakistan", R.drawable.pakistan, "Islamabad"),
            recyclerData("Israel", R.drawable.israel, "Jerusalem"),
            recyclerData("India", R.drawable.india, "New Delhi"),
            recyclerData("North Korea", R.drawable.northkorea, "Pyongyang"),
            recyclerData("Singapore", R.drawable.singapore, "Singapore"),
            recyclerData("Kazakhstan", R.drawable.kaza, "Astana (Nur-Sultan)"),
            recyclerData("Iran", R.drawable.iran, "Tehran"),
            recyclerData("Indonesia", R.drawable.indonesia, "Jakarta"),
            recyclerData("Thailand", R.drawable.thailand, "Bangkok"),
            recyclerData("Turkey", R.drawable.turkey, "Ankara"),
            recyclerData("United Arab Emirates", R.drawable.uae, "Abu Dhabi"),
            recyclerData("Vietnam", R.drawable.vietnam, "Hanoi")
        )




        val adapter = Adapter(dataList)
        recyclerView.adapter = adapter
    }
}
