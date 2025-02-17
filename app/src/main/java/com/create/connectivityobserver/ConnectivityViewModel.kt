package com.create.connectivityobserver

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.create.connectivityobserver.ConnectivityObserver
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class ConnectivityViewModel(
    private val connectiviyObserver: ConnectivityObserver
): ViewModel() {

    val isConnexted = connectiviyObserver
        .isConnected
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            false
    )
}