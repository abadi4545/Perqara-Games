package com.example.perqaragames.data.remote.dto.game


import com.google.gson.annotations.SerializedName

data class GamePlatformX(
    @SerializedName("platform")
    val platform: GamePlatform
)