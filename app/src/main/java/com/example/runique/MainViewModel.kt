package com.example.runique

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.domain.SessionStorage
import kotlinx.coroutines.launch

class MainViewModel(
    private val sessionStorage: SessionStorage
): ViewModel() {
    var state by mutableStateOf(MainState())
        private set

    init {
        viewModelScope.launch {
            state = state.copy(isCheckingAuth = true)
            state = state.copy(
                isLoggedIn = sessionStorage.get() != null
            )
            state = state.copy(isCheckingAuth = false)
        }
    }

    fun setAnalyticsDialogVisibility(isVisible: Boolean) {
        state = state.copy(showAnalyticsInstallDialog = isVisible)
    }
}