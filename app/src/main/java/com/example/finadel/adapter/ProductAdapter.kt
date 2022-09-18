package com.example.finadel.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.finadel.databinding.LayoutShopItemBinding
import com.example.finadel.model.AddProductModel
import java.nio.file.Files.list


class ProductAdapter(val context: Context, val list:ArrayList<AddProductModel>)
    : RecyclerView.Adapter<ProductAdapter.ShopViewHolder>(){

    inner class ShopViewHolder(val binding : LayoutShopItemBinding )
        :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
        val binding= LayoutShopItemBinding.inflate(LayoutInflater.from(context),parent, false)
        return ShopViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        val data=list[position]
        Glide.with(context).load(data.productCoverImg).into(holder.binding.imageView7)
        holder.binding.textView10.text=data.productName
        holder.binding.textView11.text=data.productDescription

        //button
        holder.binding.button4.text=data.productSp
    }

    override fun getItemCount(): Int {
        return list.size
    }

}