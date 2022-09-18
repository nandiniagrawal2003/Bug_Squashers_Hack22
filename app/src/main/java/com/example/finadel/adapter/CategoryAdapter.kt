package com.example.finadel.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.finadel.R
import com.example.finadel.databinding.LayoutCategoryItemBinding
import com.example.finadel.model.CategoryModel
class CategoryAdapter(var context : Context, val list: ArrayList<CategoryModel>) :RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    inner class  CategoryViewHolder(view : View) :RecyclerView.ViewHolder(view){
        var binding = LayoutCategoryItemBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_category_item, parent,false))
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        //yha nazar
        holder.binding.textView9.text=list[position].cat
        Glide.with(context).load(list[position].img).into(holder.binding.imageView6)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}