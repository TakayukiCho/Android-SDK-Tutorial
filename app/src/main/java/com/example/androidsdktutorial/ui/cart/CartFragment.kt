package com.example.androidsdktutorial.ui.cart

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.androidsdktutorial.R
import com.example.androidsdktutorial.databinding.FragmentCartBinding
import io.karte.android.tracking.Tracker

class CartFragment : Fragment() {

    private val sharedPreference by lazy {
       context?.getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_cart, container, false)

        view.findViewById<TextView>(R.id.cart_product_id).text = "ID: ${sharedPreference?.getString("id", "-")}"
        view.findViewById<TextView>(R.id.cart_price).text = "値段：${sharedPreference?.getInt("price", 0).toString()}円"
        view.findViewById<TextView>(R.id.cart_product_name).text =  sharedPreference?.getString("name", "-")

        view.findViewById<Button>(R.id.purchase).setOnClickListener(this::onPurchase)
        return view
    }

    private fun onPurchase(view: View) {
        sharedPreference?.edit()?.apply {
            remove("id")
            remove("name")
            remove("price")
            apply()
        }
        view.findViewById<TextView>(R.id.cart_product_id).text = "ID: ${sharedPreference?.getString("id", "-")}"
        view.findViewById<TextView>(R.id.cart_price).text = "値段：${sharedPreference?.getInt("price", 0).toString()}円"
        view.findViewById<TextView>(R.id.cart_product_name).text =  sharedPreference?.getString("name", "-")
        Toast.makeText(context, "購入完了", Toast.LENGTH_SHORT).show()
    }
}