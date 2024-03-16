package com.mtuci.vkpas.password

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

@Composable
fun PasswordScreen(navController: NavController){
    val viewModel = viewModel{
        val application = get(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY)!!
        val sPref = application.getSharedPreferences("data", Context.MODE_PRIVATE)
        PasswordViewModel(sPref)
    }
    val context = LocalContext.current
    val password by viewModel.password.collectAsState()

    LaunchedEffect(Unit) {
        for (action in viewModel.actions){
            when(action){
                PasswordViewModel.Action.RouteMain ->
                    navController.navigate("main"){
                    popUpTo(0)
                }

                PasswordViewModel.Action.ShowWrongAnswer ->
                    showToast(context)
            }
        }
    }

    PasswordContent(
        password = password,
        onPasswordChange = { value -> viewModel.password.value = value },
        onEnterClick = { viewModel.onEnterClick() }
    )
}

fun showToast(context: Context){
    Toast.makeText(context, "Wrong password", Toast.LENGTH_SHORT).show()
}