package com.example.advweek4.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.advweek4.R
import com.example.advweek4.model.Laptop
import com.example.advweek4.model.Student

class LaptopListAdapter(val laptopList:ArrayList<Laptop>) :RecyclerView.Adapter<LaptopListAdapter.LaptopViewHolder>(){
    class LaptopViewHolder(view: View):RecyclerView.ViewHolder(view){
        val txtBrand: TextView
        val txtModel: TextView
        val txtPrice: TextView
        init {
            txtBrand = view.findViewById(R.id.txtBrand)
            txtModel = view.findViewById(R.id.txtModel)
            txtPrice = view.findViewById(R.id.txtPrice)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaptopViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.laptop_list_item, parent, false)
        return LaptopViewHolder(view)
    }

    override fun onBindViewHolder(holder: LaptopViewHolder, position: Int) {
        holder.txtBrand.text = laptopList[position].brand
        holder.txtModel.text = laptopList[position].model
        holder.txtPrice.text = laptopList[position].price.toString()
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