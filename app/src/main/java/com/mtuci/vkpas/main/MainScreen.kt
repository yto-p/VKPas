package com.mtuci.vkpas.main

import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.room.Room
import com.mtuci.vkpas.model.SitesDatabase

@Composable
fun MainScreen(
    state: SitesState,
    navController: NavController,
    onEvent: (SitesEvent) -> Unit
){

    MainContent(
        state = state,
        addSite = { navController.navigate("site") },
        onEvent = onEvent
    )
}