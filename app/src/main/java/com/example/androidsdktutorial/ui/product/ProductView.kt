package com.example.androidsdktutorial.ui.product

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.androidsdktutorial.R

class ProductView (context : Context, attributeSet: AttributeSet) : LinearLayout(context, attributeSet) {
    private val id: String
    private val name: String
    private val image: Drawable
    private val price: Int

    init {
        // XMLとクラスを紐づける
        inflate(context, R.layout.view_product, this)

        this.orientation = VERTICAL

        val attrs = context.theme.obtainStyledAttributes(attributeSet, R.styleable.ProductView, 0, 0)
        attrs.apply {
            name = getString(R.styleable.ProductView_name)!!
            id = getString(R.styleable.ProductView_productId)!!
            image = getDrawable(R.styleable.ProductView_image)!!
            price = getInt(R.styleable.ProductView_price, 0)
        }

        findViewById<TextView>(R.id.product_name).text = name
        findViewById<TextView>(R.id.product_price).text = "${price.toString()}円"
        findViewById<ImageView>(R.id.product_image).setImageDrawable(image)
        findViewById<Button>(R.id.add_to_cart).setOnClickListener {
            // TODO: ストレージに保存
            Toast.makeText(context, "${name}がカートに追加されました", Toast.LENGTH_SHORT).show()
        }
    }
}