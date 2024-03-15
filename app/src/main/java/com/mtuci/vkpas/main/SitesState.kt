package com.mtuci.vkpas.main

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.mtuci.vkpas.model.Site
import kotlinx.coroutines.flow.MutableStateFlow

data class SitesState(
    val sites: List<Site> = emptyList(),
    val name: MutableState<String> = mutableStateOf(""),
    val link: MutableState<String> = mutableStateOf(""),
    val password: MutableState<String> = mutableStateOf("")
)
