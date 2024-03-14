package com.mtuci.vkpas.model

data class SiteData(
    val id: Int,
    val name: String,
    val link: String,
    val password: String,
    val icon: Int,
    val openSite: () -> Unit
)
