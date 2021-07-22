package com.example.infosysexample

import android.graphics.Color
import android.util.TypedValue
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.infosysexample.dataclasses.CardG
import com.example.infosysexample.dataclasses.Description
import com.example.infosysexample.dataclasses.Image
import com.example.infosysexample.dataclasses.Title
import com.example.infosysexample.ui.main.CardsAdapter


//these tell our views how to use arbitrary data classes that get passed to them
//this file is where the app determines how to render each card, largly by hiding parts
//  the current card does not use
@BindingAdapter("cardlist")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<CardG>?) {
    val adapter = recyclerView.adapter as CardsAdapter
    adapter.submitList(data)
}

@BindingAdapter("cardtitle")
fun bindCardTitle(tv: TextView, title: Title) {
    tv.text = title.value
    tv.setTextColor(Color.parseColor(title.attributes.text_color))
    tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, title.attributes.size.toFloat())
}

@BindingAdapter("cardimage")
fun bindCardImage(iv: ImageView, image: Image) {
    image.url?.let {
        Glide.with(iv.context).load(it.toUri().buildUpon().scheme("https").build()).into(iv)
    } ?: run {
        Glide.with(iv.context).clear(iv)
    }
}

@BindingAdapter("carddescription")
fun bindCardDescription(tv: TextView, description: Description) {
    description.value?.let {
        tv.text = it
        tv.setTextColor(Color.parseColor(description.attributes.text_color))
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, description.attributes.size.toFloat())
    } ?: run {
        tv.visibility = View.GONE
    }
}