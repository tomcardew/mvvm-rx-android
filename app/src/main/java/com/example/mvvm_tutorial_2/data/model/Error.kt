package com.example.mvvm_tutorial_2.data.model

import com.google.gson.annotations.SerializedName

data class Error(

    @SerializedName("code")
    val code: Int = 500,

    @SerializedName("message")
    val message: String = "Unknown error"

)