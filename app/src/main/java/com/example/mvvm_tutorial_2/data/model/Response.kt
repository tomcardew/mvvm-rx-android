package com.example.mvvm_tutorial_2.data.model

import com.google.gson.annotations.SerializedName

data class Response<out T>(

    @SerializedName("success")
    val success: Boolean = false,

    @SerializedName("data")
    val data: T? = null,

    @SerializedName("error")
    val error: Error? = null

)