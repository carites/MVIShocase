package viewModel.stateReducers

import viewModel.StateManager
//import viewModel.appState.HomeData

fun StateManager.setHomeScreenDefaults() {
//    val homeData = HomeData(dataRepository.getPersonName())
    state = state.copy(personNameLabelText = dataRepository.getPersonName())
}

fun StateManager.setPersonName(name: String) {
//    val homeData = HomeData(name)
    state = state.copy(personNameLabelText = name)
}

fun StateManager.createPerson(name: String) {
    dataRepository.createPerson(name)
    state = state.copy(
        personNameLabelText = "",
        people = dataRepository.getPeople()
    )
}