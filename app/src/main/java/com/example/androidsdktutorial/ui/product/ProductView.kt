package com.example.androidsdktutorial.ui.product

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.androidsdktutorial.R

class ProductView (context : Context, attributeSet: AttributeSet) : LinearLayout(context, attributeSet) {
    private val button: Button

    private val id: String
    private val name: String
    private val image: Drawable
    private val price: Int

    init {
        // XMLとクラスを紐づける
        inflate(context, R.layout.view_product, this)

        this.orientation = VERTICAL

        val attrs = context.theme.obtainStyledAttributes(attributeSet, R.styleable.ProductView, 0, 0)

        // テキストを埋め込む

        // 画像を埋め込む
        attrs.apply {
            name = getString(R.styleable.ProductView_name)!!
            id = getString(R.styleable.ProductView_productId)!!
            image = getDrawable(R.styleable.ProductView_image)!!
            price = getInt(R.styleable.ProductView_price, 0)
        }

        findViewById<TextView>(R.id.product_name).text = name
        findViewById<TextView>(R.id.product_price).text = "${price.toString()}円"
        findViewById<ImageView>(R.id.product_image).setImageDrawable(image)
        // 各ボタンのインスタンスを取得
        button = findViewById(R.id.add_to_cart)
    }

}