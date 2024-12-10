package com.example.a2ite393

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class CountryAdapter (val countryList: List <Country>) : RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    class ViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {

        val countryName = itemView.findViewById<TextView>(R.id.txtCountryName)
        val flag = itemView.findViewById<CircleImageView>(R.id.ivFlag)
        val capital = itemView.findViewById<TextView>(R.id.txtCapital)
        val btnPlane = itemView.findViewById<ImageButton>(R.id.btnPlane)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent,false))
    }

    override fun onBindViewHolder(holder: CountryAdapter.ViewHolder, position: Int) {
        val country = countryList [position]

        holder.countryName.text = country.countryName
        holder.flag.setImageResource(country.flag)
        holder.capital.text = country.capital

        val btnPlane = holder.btnPlane
        var marked = false


        btnPlane.setOnClickListener {
            val yellowColor = Color.parseColor("#d5d808")
            btnPlane.setColorFilter(yellowColor)

            if (marked) {
                btnPlane.setColorFilter(null)
            } else {
                btnPlane.setColorFilter(yellowColor)
            }

            marked = !marked

        }
    }

    override fun getItemCount(): Int {
        return countryList.size
    }
}