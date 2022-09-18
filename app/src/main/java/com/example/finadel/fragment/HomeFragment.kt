package com.example.finadel.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.NotificationCompat.getCategory
import com.bumptech.glide.Glide
import com.example.finadel.R
import com.example.finadel.adapter.CategoryAdapter
import com.example.finadel.adapter.ProductAdapter
import com.example.finadel.databinding.ActivityMainBinding
import com.example.finadel.databinding.FragmentHomeBinding
import com.example.finadel.model.AddProductModel
import com.example.finadel.model.CategoryModel
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.ArrayList


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentHomeBinding.inflate(layoutInflater)
        getCategories()
        getproducts()
        getSliderImage()
        return binding.root
    }

    private fun getSliderImage() {
        Firebase.firestore.collection("slider").document("item")
            .get().addOnSuccessListener {
                Glide.with(requireContext()).load(it.get("img")).into(binding.sliderimage)
            }
    }

    private fun getproducts() {
        var list= ArrayList<AddProductModel>()
        Firebase.firestore.collection("products")
            .get().addOnSuccessListener {
                list.clear()
                for (doc in it.documents){
                    val data = doc.toObject(AddProductModel::class.java)
                    list.add(data!!)
                }
                binding.productRecycler.adapter= ProductAdapter(requireContext(),list)
            }

    }

    private fun getCategories() {
        var list= ArrayList<CategoryModel>()
        Firebase.firestore.collection("categories")
            .get().addOnSuccessListener {
                list.clear()
                for (doc in it.documents){
                    val data = doc.toObject(CategoryModel::class.java)
                    list.add(data!!)
                }
                binding.categoryRecycler.adapter= CategoryAdapter(requireContext(),list)
            }
    }

}


