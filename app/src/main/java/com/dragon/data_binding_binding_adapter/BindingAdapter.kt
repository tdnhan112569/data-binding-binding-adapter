package com.dragon.data_binding_binding_adapter

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import com.squareup.picasso.Picasso

@BindingAdapter("android:text")
fun setText(view: EditText, string: String) {
    view.setTextColor(
        if (string.length < 6) {
            Color.RED
        } else if (string.length < 20) {
            Color.BLUE
        } else if (string.length < 50) {
            Color.YELLOW
        } else if (string.length < 100){
            Color.TRANSPARENT
        } else Color.GREEN
    )
    view.setText(string)
    view.setSelection(string.length)
}

@BindingAdapter("android:paddingLeft")
fun setPaddingLeft(view: View, padding: Int) {
    view.setPadding(
        padding,
        padding,
        padding,
        padding
    )
}

@BindingAdapter(value = ["imageUrl", "error"], requireAll = false)
fun loadImage(view: ImageView, url: String?, error: Drawable?) {
    if(error != null) {
        Picasso.get().load(url)
            .error(error)
            .resize(200, 200)
            .centerCrop()
            .into(view)
    } else {
        Picasso.get()
            .load(url)
            .resize(200, 200)
            .centerCrop()
            .into(view)
    }

}

@BindingAdapter("app:greetings")
fun sayGreetings(view : TextView, text : String) {
    view.text = String.format("Welcome, %s", text)
}
