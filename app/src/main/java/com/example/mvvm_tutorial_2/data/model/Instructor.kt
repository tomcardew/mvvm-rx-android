package com.example.mvvm_tutorial_2.data.model

import com.google.gson.annotations.SerializedName

data class Instructor(

    @SerializedName("id")
    val id: Int = 0,

    @SerializedName("name")
    val name: String = "",

    @SerializedName("lastname")
    val lastname: String = "",

    @SerializedName("description")
    val description: String = "",

    @SerializedName("profilePicture")
    val profilePicture: String = "",

    @SerializedName("largePicture")
    val largePicture: String = "",

    @SerializedName("isDeleted")
    val isDeleted: Boolean = false,

    @SerializedName("isVisible")
    val isVisible: Boolean = false,

    @SerializedName("createdAt")
    val createdAt: String = "",

)