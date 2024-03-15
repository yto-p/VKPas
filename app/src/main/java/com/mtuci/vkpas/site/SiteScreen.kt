package com.mtuci.vkpas.site

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.mtuci.vkpas.main.SitesEvent
import com.mtuci.vkpas.main.SitesState

@Composable
fun SiteScreen(state: SitesState,
               navController: NavController,
               onEvent: (SitesEvent) -> Unit){

    SiteContent(
        state = state,
        onEvent = onEvent,
        onBackClick = { navController.navigateUp() })
}