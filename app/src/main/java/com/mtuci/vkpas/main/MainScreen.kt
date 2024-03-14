package com.mtuci.vkpas.main

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.mtuci.vkpas.R
import com.mtuci.vkpas.model.SiteData

@Composable
fun MainScreen(navController: NavController){
    val viewModel = viewModel{
        MainViewModel()
    }
    val sites = listOf(
        SiteData(
            id = 0,
            name = "Yandex",
            link = "yandex.ru",
            password = "",
            icon = R.drawable.yandex,
            openSite = {navController.navigate("site")}
        ),
        SiteData(
            id = 1,
            name = "VK",
            link = "vk.com",
            password = "",
            icon = R.drawable.vkontakte,
            openSite = {navController.navigate("site")}
        )
    )
    MainContent(sites) { navController.navigate("site") }
}