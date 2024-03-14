package com.mtuci.vkpas.site

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class SiteViewModel : ViewModel() {
    val name = MutableStateFlow("")
    val link = MutableStateFlow("")
    val password = MutableStateFlow("")
}