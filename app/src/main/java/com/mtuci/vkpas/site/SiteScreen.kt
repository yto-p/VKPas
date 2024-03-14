package com.mtuci.vkpas.site

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun SiteScreen(navController: NavController){
    val viewModel = viewModel{
        SiteViewModel()
    }

    val name by viewModel.name.collectAsState()
    val link by viewModel.link.collectAsState()
    val password by viewModel.password.collectAsState()

    SiteContent(
        name = name,
        link = link,
        password = password,
        onNameChange = { value -> viewModel.name.value = value },
        onLinkChange = { value -> viewModel.link.value = value },
        onPasswordChange = { value -> viewModel.password.value = value },
        onBackClick = { navController.navigateUp() },
        onSaveSiteClick = { navController.navigateUp() }
    )
}