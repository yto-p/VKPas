package com.mtuci.vkpas.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Site(
    val name: String,
    val link: String,
    val password: String,
    val dateAdded: Long,

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
