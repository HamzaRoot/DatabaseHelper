package com.rootcoder.globalizegym.helpingclasses

import android.content.Context
import android.net.Uri
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.interfaces.DraweeController
import com.facebook.drawee.view.SimpleDraweeView
import com.facebook.imagepipeline.request.ImageRequestBuilder
import com.rootcoder.mvvmdemo.Constants
import java.text.SimpleDateFormat
import java.util.*

class Helper {
    companion object{



    fun getAppFolder(context: Context): String? {
        return try {
            context.getExternalFilesDir(null)!!.absolutePath
        } catch (e: Exception) {
            ""
        }
    }


    //fresco image url load


        fun frescoImageLoad(
            urlImage: String,
            placeholder: Int,
            draweeView: SimpleDraweeView,
            isGif: Boolean
        ): DraweeController? {
            var url=urlImage;
            if (!url.contains(Constants.http)) {
                url = Constants.Url+ url
            }
            println("URL: $url")

            val request = ImageRequestBuilder.newBuilderWithSource(Uri.parse(url))
                .build()
            val controller: DraweeController
            draweeView.hierarchy.setPlaceholderImage(placeholder)
            draweeView.hierarchy.setFailureImage(placeholder)
            controller = if (isGif) {
                Fresco.newDraweeControllerBuilder()
                    .setImageRequest(request)
                    .setAutoPlayAnimations(true)
                    .build()
            } else {
                Fresco.newDraweeControllerBuilder()
                    .setImageRequest(request)
                    .build()
            }
            return controller
        }



        //fresco image Uri load
        //fresco load with placeholder
        fun frescoImageLoad(
            resourceUri: Int,
            placeholder: Int,
            draweeView: SimpleDraweeView,
            isGif: Boolean
        ): DraweeController? {
            val request = ImageRequestBuilder.newBuilderWithResourceId(resourceUri)
                .build()
            val controller: DraweeController
            draweeView.hierarchy.setPlaceholderImage(placeholder)
            draweeView.hierarchy.setFailureImage(placeholder)
            controller = if (isGif) {
                Fresco.newDraweeControllerBuilder()
                    .setImageRequest(request)
                    .setAutoPlayAnimations(true)
                    .build()
            } else {
                Fresco.newDraweeControllerBuilder()
                    .setImageRequest(request)
                    .build()
            }
            return controller
        }


        fun getCurrrentDate(format: String?): String? {
            return try {
                val f = SimpleDateFormat(format, Locale.ENGLISH)
                val currentTime = Calendar.getInstance().time
                f.format(currentTime)
            } catch (e: java.lang.Exception) {
                ""
            }
        }

    }
}