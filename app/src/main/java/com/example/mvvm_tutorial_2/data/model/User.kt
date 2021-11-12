package com.example.mvvm_tutorial_2.data.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("id")
    val id: String = "",

    @SerializedName("name")
    val name: String = "",

    @SerializedName("lastname")
    val lastname: String = "",

    @SerializedName("email")
    val email: String = "",

    @SerializedName("pictureUrl")
    val pictureUrl: String = "",

    @SerializedName("facebookId")
    val facebookId: String? = null,

    @SerializedName("googleId")
    val googleId: String? = null,

    @SerializedName("tempToken")
    val tempToken: String? = null,

    @SerializedName("isAdmin")
    val isAdmin: Boolean = false,

    @SerializedName("isDeleted")
    val isDeleted: Boolean = false,

    @SerializedName("createdAt")
    val createdAt: String = "",

    @SerializedName("isLeader")
    val isLeader: Boolean = false,

    @SerializedName("fromGroup")
    val fromGroup: String? = null,

    @SerializedName("groupName")
    val groupName: String? = null,

    @SerializedName("changed")
    val changed: Int = 0,

    @SerializedName("User_categories")
    val categories: List<Category> = emptyList(),

    )