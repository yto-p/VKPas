package com.mtuci.vkpas.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun MainScreen(
    state: SitesState,
    navController: NavController,
    onEvent: (SitesEvent) -> Unit
){

    MainContent(
        state = state,
        addSite = { navController.navigate("site") },
        editSite = { navController.navigate("site") },
        onEvent = onEvent
    )
}