package com.example.edmt.ui.login.model
import com.google.gson.annotations.SerializedName



data class trips(  @SerializedName("car")
                   var car: String = ""  ,
                   @SerializedName("start")
                   var start: String= ""  ,
                   @SerializedName("user")
                   var user :String = "",
                   @SerializedName("garage")
                   var garage :String = ""
)
