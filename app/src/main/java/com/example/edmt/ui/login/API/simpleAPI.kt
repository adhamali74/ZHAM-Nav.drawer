package com.example.edmt.ui.login.API

import com.example.edmt.ui.login.model.Login_schema
import com.example.edmt.ui.login.model.Ride_request
import com.example.edmt.ui.login.model.Signup_schema
import com.example.edmt.ui.login.model.trips
import com.example.edmt.ui.login.model.cars
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface simpleAPI {




    @POST("/Login")
    suspend fun pushPost(
            @Body Post: Login_schema
    ): Response<Login_schema>


    @POST("/register")
    suspend fun Signup(
        @Body Post: Signup_schema
    ): Response<Signup_schema>

    @GET("/get-car")
    suspend fun get_cars(
        @Query("lat") lat:Number,
        @Query("long") long:Number,
        @Query("Class") Class:String,
    ): Response<JsonArray>


    @GET("get-class")
    suspend fun get_class(
        @Query("Class") Class: String,
    ): Response<JsonObject>


    @POST("start-trip")
    suspend fun start_trip(
        @Body Post: trips
    ):Response<ResponseBody>
}