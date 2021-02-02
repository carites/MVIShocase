package viewModel

import kotlinx.coroutines.flow.MutableStateFlow
import repositories.Repository
import viewModel.appState.AppState

class StateManager() {
    internal val mutableStateFlow = MutableStateFlow(AppState())
    internal var state: AppState
        get() = mutableStateFlow.value
        set (value) { mutableStateFlow.value = value }
    internal val dataRepository by lazy { Repository() }
}