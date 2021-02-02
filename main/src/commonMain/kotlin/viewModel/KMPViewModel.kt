package viewModel

import io.ktor.utils.io.core.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import viewModel.appState.AppState

class KMPViewModel() {
    val stateFlow: StateFlow<AppState>
        get() = stateManager.mutableStateFlow
    internal val stateManager by lazy { StateManager() }

}

fun KMPViewModel.onChange(provideNewState: ((AppState) -> Unit)) : Closeable {
    val job = Job()
    stateFlow.onEach {
        provideNewState(it)
    }.launchIn(
            CoroutineScope(Dispatchers.Main + job)
    )
    return object : Closeable {
        override fun close() {
            job.cancel()
        }
    }
}