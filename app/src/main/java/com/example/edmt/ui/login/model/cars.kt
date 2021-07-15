package com.example.edmt.ui.login.model
import com.google.gson.annotations.SerializedName


data class cars(
    @SerializedName("UUID")
    var UUID: String = ""  ,
    @SerializedName("brand")
    var brand: String= ""  ,
    @SerializedName("plate")
    var plate :String = "",
    @SerializedName("color")
    var color :String = "",
    @SerializedName("garageID")
    var GarageID :String = "",
    @SerializedName("class")
    var Class :String = "",
    @SerializedName("sate")
    var state :String = "",
)
