package repositories

import data.models.Person

class Repository {
    private var currentPerson: Person? = null
    private val people: MutableList<Person> = mutableListOf()
    fun getPersonName(): String {
        return currentPerson?.name ?: "No name set"
    }

    fun createPerson(name: String) {
        people.add(Person(name))
    }

    fun getPeople(): List<Person> {
        return people
    }
}