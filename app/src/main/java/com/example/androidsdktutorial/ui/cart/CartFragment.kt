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

class CartFragment : Fragment() {

    private var _binding: FragmentCartBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val sharedPreference by lazy {
       context?.getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        val root: View = binding.root

        root.findViewById<TextView>(R.id.cart_product_id).text = "ID: ${sharedPreference?.getString("id", "-")}"
        root.findViewById<TextView>(R.id.cart_price).text = "値段：${sharedPreference?.getInt("price", 0).toString()}円"
        root.findViewById<TextView>(R.id.cart_product_name).text =  sharedPreference?.getString("name", "-")

        root.findViewById<Button>(R.id.purchase).setOnClickListener {
            sharedPreference?.edit()?.apply {
                remove("id")
                remove("name")
                remove("price")
                apply()
            }
            root.findViewById<TextView>(R.id.cart_product_id).text = "ID: ${sharedPreference?.getString("id", "-")}"
            root.findViewById<TextView>(R.id.cart_price).text = "値段：${sharedPreference?.getInt("price", 0).toString()}円"
            root.findViewById<TextView>(R.id.cart_product_name).text =  sharedPreference?.getString("name", "-")
            Toast.makeText(context, "購入完了", Toast.LENGTH_SHORT).show()
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}