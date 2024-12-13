package com.example.a2ite393

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CountryAdapter(private val countryList: List<Country>) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    // ViewHolder class
    class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val countryTextView: TextView = itemView.findViewById(R.id.countryName)
        val capitalTextView: TextView = itemView.findViewById(R.id.countryCapital)
        val countryImageView: ImageView = itemView.findViewById(R.id.countryImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countryList[position]
        holder.countryTextView.text = country.name
        holder.capitalTextView.text = "Capital: ${country.capital}"
        holder.countryImageView.setImageResource(country.imageResId)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }
}
