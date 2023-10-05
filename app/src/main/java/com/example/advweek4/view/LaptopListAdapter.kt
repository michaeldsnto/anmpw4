package com.example.advweek4.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.advweek4.R
import com.example.advweek4.model.Laptop
import com.example.advweek4.model.Student
import com.squareup.picasso.Picasso

class LaptopListAdapter(val laptopList:ArrayList<Laptop>) :RecyclerView.Adapter<LaptopListAdapter.LaptopViewHolder>(){
    class LaptopViewHolder(view: View):RecyclerView.ViewHolder(view){
        val txtBrand: TextView
        val txtModel: TextView
        val txtPrice: TextView
        val photoLaptop: ImageView
        init {
            txtBrand = view.findViewById(R.id.txtBrand)
            txtModel = view.findViewById(R.id.txtModel)
            txtPrice = view.findViewById(R.id.txtPrice)
            photoLaptop = view.findViewById(R.id.photoLaptop)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaptopViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.laptop_list_item, parent, false)
        return LaptopViewHolder(view)
    }

    override fun onBindViewHolder(holder: LaptopViewHolder, position: Int) {
        holder.txtBrand.text = "Brand: " + laptopList[position].brand
        holder.txtModel.text = "Model: " + laptopList[position].model
        holder.txtPrice.text = "Price: " + laptopList[position].price.toString()
        val imageUrl = laptopList[position].photoLaptop
        Picasso.get().load(imageUrl).resize(350, 300).into(holder.photoLaptop)
    }

    override fun getItemCount(): Int {
        return laptopList.size
    }

    fun updateLaptopList(newLaptopList: java.util.ArrayList<Laptop>){
        laptopList.clear()
        laptopList.addAll(newLaptopList)
        notifyDataSetChanged()
    }
}