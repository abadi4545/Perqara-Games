package com.example.perqaragames.data.remote.dto.game


import com.google.gson.annotations.SerializedName

data class GameStoreX(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("slug")
    val slug: String
)