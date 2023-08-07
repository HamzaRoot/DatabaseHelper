package com.rootcoder.mvvmdemo.retrofitclasses.amenitiesmodel

data class AmenitiesPostModel(
    val code: Int,
    val `data`: List<Data>,
    val message: String,
    val status: Boolean
)