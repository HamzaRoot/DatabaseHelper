package com.rootcoder.mvvmdemo.retrofitclasses.amenitiesmodel

data class Unit(
    val AdvanceSecurity: Int,
    val Amenities: List<Amenity>,
    val Arabic: String,
    val English: String,
    val ExtraAmenities: String,
    val Id: Int,
    val Images: List<String>,
    val IstrahaId: Int,
    val ListOfExtraAmenities: List<String>,
    val Rate: Int,
    val SpecialDayPrice: Int,
    val Timings: List<Timing>,
    val WeekendPrice: Int,
    val WeeklyPrice: Int,
    val WholeDayPrice: Int
)