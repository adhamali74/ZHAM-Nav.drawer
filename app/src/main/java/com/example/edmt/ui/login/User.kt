package com.example.edmt.ui.login

import com.google.gson.annotations.SerializedName

data class User(
                @SerializedName("Firstname")
        var first_name: String ="" ,
                @SerializedName("Middlename")
        var middle_name: String ="" ,
                @SerializedName("Lastname")
        var last_name: String = "" ,
                @SerializedName("Email")
        var email: String = "" ,
                @SerializedName("Password")
        var password:String = "" ,
                @SerializedName("Phone")
        var phone_number: Int = 0 ,
                @SerializedName("Birthdate")
        var birth_date: String = "" ,
                @SerializedName("Gender")
        var gender: String = "" ,
                @SerializedName("CardNumber")
        var card_number: String = "",
                @SerializedName("State")
        var state: Boolean ,
)
