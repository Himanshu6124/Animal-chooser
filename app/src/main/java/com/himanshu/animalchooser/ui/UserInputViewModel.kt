package com.himanshu.animalchooser.ui

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.himanshu.animalchooser.data.UserDataUIEvents
import com.himanshu.animalchooser.data.UserInputScreenState

class UserInputViewModel : ViewModel() {
    private val TAG: String = this.javaClass.name
    private val _uiState = mutableStateOf(UserInputScreenState())
    val uiState :State<UserInputScreenState> = _uiState

    fun onEvent(event: UserDataUIEvents) {
        Log.d(TAG,event.toString())
        when (event) {
            is UserDataUIEvents.UserNameEntered -> {
                _uiState.value = uiState.value.copy(nameEntered = event.name)
            }
            is UserDataUIEvents.AnimalSelected -> {
                _uiState.value = uiState.value.copy(animalSelected = event.animalName)
            }
        }
    }
    fun isValid() :Boolean{
        return uiState.value.animalSelected.isNotEmpty() && uiState.value.nameEntered.isNotEmpty()
    }
}