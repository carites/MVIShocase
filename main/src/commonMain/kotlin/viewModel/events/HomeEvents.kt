package viewModel.events

import viewModel.KMPViewModel
import viewModel.stateReducers.createPerson
import viewModel.stateReducers.setHomeScreenDefaults
import viewModel.stateReducers.setPersonName

fun KMPViewModel.initHomeScreen() {
    stateManager.setHomeScreenDefaults()
}

fun KMPViewModel.personNameChanged(name: String) {
    stateManager.setPersonName(name)
}

fun KMPViewModel.createButtonPressed(name: String) {
    stateManager.createPerson(name)
}