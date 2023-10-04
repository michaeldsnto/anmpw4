package com.example.advweek4.model

import com.google.gson.annotations.SerializedName

data class Student(
    val id:String?,
    @SerializedName("student_name")
    val nama:String?,
    @SerializedName("birth_of_date")
    val bod:String?,
    val phone:String?,
    @SerializedName("photo_url")
    val photoUrl:String
)

data class Laptop(
    val id:Int?,
    val brand:String?,
    val model:String?,
    val releaseYear:Int?,
    val color:String?,
    val price:Double?,
    val features:List<String>,
    val specs:Specs?,
    val photoLaptop:String?
)
data class Specs(
    val processor:String?,
    val memory:String?,
    val storage:String?
)
