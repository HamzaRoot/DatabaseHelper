package com.rootcoder.globalizegym.applicationlevel

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import com.rootcoder.mvvmdemo.helpingclasses.ImagePipelineConfigUtils

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(
            applicationContext, ImagePipelineConfigUtils.getDefaultImagePipelineConfig(
                applicationContext)
        )
    }
}