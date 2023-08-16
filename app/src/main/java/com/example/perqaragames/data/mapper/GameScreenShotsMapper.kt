package com.example.perqaragames.data.mapper

import com.example.perqaragames.data.remote.dto.game_screenshots.GameScreenShotResponse


fun GameScreenShotResponse.toGameScreenShots(): List<String?> {
    return results?.map { it?.image } ?: emptyList()
}