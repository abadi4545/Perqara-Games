package com.example.perqaragames.data.remote.dto.game


import com.google.gson.annotations.SerializedName

data class GameStore(
    @SerializedName("store")
    val store: GameStoreX
)