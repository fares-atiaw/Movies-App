package com.example.simplemoviesdetails.utils

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.simplemoviesdetails.R

@BindingAdapter("android:imageUrl")
fun bindImage(imageView : ImageView, imageUrl :String?)
{
    imageUrl?.let {
        val image = it.toUri().buildUpon().scheme("https").build()
        Glide.with(imageView.context)
            .load(image)
            .apply(
                RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image))
            .into(imageView)
    }
}

@BindingAdapter("android:actualText")
fun bindText(view : TextView, text :String?)
{
    if(text.isNullOrEmpty())
        view.visibility = View.GONE
    else{
        view.visibility = View.VISIBLE
        view.text = "📌 $text"
        Log.e("heree",text)
    }
}
