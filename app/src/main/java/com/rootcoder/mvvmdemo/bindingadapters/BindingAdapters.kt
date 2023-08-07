package com.rootcoder.mvvmdemo.bindingadapters

import android.net.Uri
import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.facebook.drawee.view.SimpleDraweeView
import com.rootcoder.globalizegym.helpingclasses.Helper
import com.rootcoder.mvvmdemo.R

@BindingAdapter("imageLoadFromURL")
fun SimpleDraweeView.imageLoadFromURL(url:String){
    this.controller= Helper.frescoImageLoad(url, R.mipmap.ic_launcher,this,false)
}
