package com.example.mvvm_tutorial_2.data.model

import com.google.gson.annotations.SerializedName

data class MeResponse(
    @SerializedName("success")
    val success: Boolean = false,

    @SerializedName("data")
    val data: Profile? = null,

    @SerializedName("error")
    val error: Error? = null
)

data class Profile(
    @SerializedName("profile")
    val profile: User? = null,

    @SerializedName("minutesDone")
    val minutesDone: Int = 0,

    @SerializedName("favorite")
    val favorite: String = "",
)

data class UserCategory(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("Categories")
    val category: Category? = null,
)

data class Category(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("description")
    val description: String = "",
    @SerializedName("type")
    val type: String = "",
    @SerializedName("User_items")
    val items: UserItem? = null,
)

data class UserItem(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("description")
    val description: String = "",
    @SerializedName("pictureUrl")
    val pictureUrl: String = "",
)