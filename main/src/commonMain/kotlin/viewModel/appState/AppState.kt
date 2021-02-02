package viewModel.appState

import data.models.Person

data class AppState (
    val personNameLabelText: String = "",
    val people: List<Person> = listOf()
)