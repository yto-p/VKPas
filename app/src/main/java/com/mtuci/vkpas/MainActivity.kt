package com.mtuci.vkpas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mtuci.vkpas.main.MainScreen
import com.mtuci.vkpas.site.SiteScreen
import com.mtuci.vkpas.ui.theme.VKPasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VKPasTheme {
                val navController = rememberNavController()

                NavHost(
                    startDestination = "main",
                    navController = navController
                ) {
                    composable("main") {
                        MainScreen(navController)
                    }
                    composable("site") {
                        SiteScreen(navController = navController)
                    }
                }
            }
        }
    }
}