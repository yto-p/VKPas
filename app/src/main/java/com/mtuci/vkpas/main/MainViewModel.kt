package com.mtuci.vkpas.main

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mtuci.vkpas.model.Site
import com.mtuci.vkpas.model.SiteDao
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    private val dao: SiteDao
): ViewModel() {
    private val isSortedByDataAdded = MutableStateFlow(true)

    @OptIn(ExperimentalCoroutinesApi::class)
    private var sites = isSortedByDataAdded.flatMapLatest {
        dao.getSitesOrderedByDateAdded()
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    private var _state = MutableStateFlow(SitesState())
    val state =
        combine(_state, sites){ state, sites ->
            state.copy(
                sites = sites
            )
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), SitesState())

    fun onEvent(event: SitesEvent){
        when (event) {
            is SitesEvent.DeleteSite -> {
                viewModelScope.launch {
                    dao.deleteSite(event.site)
                }
            }
            is SitesEvent.SaveSite -> {
                val site = Site(
                        name = state.value.name.value,
                        link = state.value.link.value,
                        password = state.value.password.value,
                        dateAdded = System.currentTimeMillis()
                    )
                viewModelScope.launch {
                    dao.upsertSite(site)
                }
                _state.update {
                    it.copy(
                        name = mutableStateOf(""),
                        link = mutableStateOf(""),
                        password = mutableStateOf("")
                    )
                }
            }

            SitesEvent.SortSites -> {
                isSortedByDataAdded.value = !isSortedByDataAdded.value
            }
        }
    }
}