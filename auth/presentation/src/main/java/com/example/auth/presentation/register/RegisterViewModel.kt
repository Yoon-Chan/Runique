package com.example.auth.presentation.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.auth.domain.UserDataValidator
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class RegisterViewModel(
    private val userDataValidator: UserDataValidator
): ViewModel() {
    var state by mutableStateOf(RegisterState())
        private set

    init {

        /*
            textAsFlow는 Jetpack Compose 1.6.0-alpha03 (2023년 8월 릴리스) 기준으로 제거
        *   state.email.textAsFlow()
        *       .onEach { email -> }
        *       .launchIn(viewModelScope)
        * */
        snapshotFlow { state.email.text.toString() }
            .onEach { email ->
                state = state.copy(
                    isEmailValid = userDataValidator.isValidEmail(email)
                )
            }
            .launchIn(viewModelScope)

        snapshotFlow { state.password.text.toString() }
            .onEach { password ->
                state = state.copy(
                    passwordValidationState = userDataValidator.validatePassword(password)
                )
            }
            .launchIn(viewModelScope)
    }
    fun onAction(action: RegisterAction) {

    }
}