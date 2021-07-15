package com.example.edmt.ui.login.model
import com.google.gson.annotations.SerializedName

data class Ride_request(
    @SerializedName("lat")
    var lat: Number  ,
    @SerializedName("long")
    var long: Number  ,
    @SerializedName("class")
    var Class :String = ""
)
