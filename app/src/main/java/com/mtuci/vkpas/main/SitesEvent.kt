package com.mtuci.vkpas.main

import com.mtuci.vkpas.model.Site

sealed interface SitesEvent {
    object SortSites: SitesEvent
    data class DeleteSite(val site: Site): SitesEvent

    data class SaveSite(
        val name: String,
        val link: String,
        val password: String
    ): SitesEvent
}