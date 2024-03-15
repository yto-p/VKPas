package com.mtuci.vkpas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.mtuci.vkpas.main.MainScreen
import com.mtuci.vkpas.main.MainViewModel
import com.mtuci.vkpas.model.SitesDatabase
import com.mtuci.vkpas.site.SiteScreen
import com.mtuci.vkpas.ui.theme.VKPasTheme

class MainActivity : ComponentActivity() {
    val database by lazy{
        Room.databaseBuilder(
            applicationContext,
            SitesDatabase::class.java,
            "sites.db"
        ).build()
    }
    val viewModel by viewModels<MainViewModel>(
        factoryProducer = {
            object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return MainViewModel(database.dao) as T
                }
            }
        }
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VKPasTheme {
                val navController = rememberNavController()
                val state by viewModel.state.collectAsState()

                NavHost(
                    startDestination = "main",
                    navController = navController
                ) {
                    composable("main") {
                        MainScreen(
                            state = state,
                            navController = navController,
                            onEvent = viewModel::onEvent)
                    }
                    composable("site") {
                        SiteScreen(state = state,
                            navController = navController,
                            onEvent = viewModel::onEvent)
                    }
                }
            }
        }
    }
}