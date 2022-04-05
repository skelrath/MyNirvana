package com.example.mynirvana.domain.meditations.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mynirvana.R


@Entity
data class Meditation(
    val header: String,
    val time: Long,
    val imageResourceId: Int,
    val soundResourceId: Int = R.raw.rain_sound,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
)