package com.mtuci.vkpas.password

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class PasswordViewModel(private val sPref: SharedPreferences): ViewModel() {
    val password = MutableStateFlow("")
    val actions = Channel<Action>()
    private var pas: String? = sPref.getString("password", null)

    fun onEnterClick(){
        viewModelScope.launch {
            if (pas == null && password.value.trim().length > 3){
                sPref.edit().putString("password", password.value).apply()
                actions.send(Action.RouteMain)
            } else if (password.value == pas){
                actions.send(Action.RouteMain)
            } else {
                actions.send(Action.ShowWrongAnswer)
            }
        }
    }

    sealed interface Action{
        object RouteMain : Action
        object ShowWrongAnswer: Action

    }
}