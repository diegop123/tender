package com.example.practico3tindermo.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.practico3tindermo.Person
import com.example.practico3tindermo.R

class MainViewModel : ViewModel() {

    private val _person = MutableLiveData<Person?>()
    val person: LiveData<Person?> = _person

    private val people = mutableListOf(
        Person("Nobara ", listOf(R.drawable.persona1_imagen1, R.drawable.persona1_imagen2, R.drawable.persona1_imagen3)),
        Person("Maki", listOf(R.drawable.persona2_iamgen1, R.drawable.persona2_imagen2, R.drawable.persona2_imagen3)),
        Person("Geralt de Rivia", listOf(R.drawable.persona3_imagen1, R.drawable.persona3_imagen2, R.drawable.persona3_imagen33)),
        Person("Spike Spiegel", listOf(R.drawable.persona4_imagen1, R.drawable.persona4_imagen2, R.drawable.persona4_imagen3))
    )

    private val likedPeople = mutableListOf<Person>()
    private var index = 0

    init {
        loadNextPerson()
    }

    fun likePerson() {
        _person.value?.let { person ->
            likedPeople.add(person)
            people.remove(person)
        }
        loadNextPerson()
    }

    fun dislikePerson() {
        _person.value?.let { person ->
            people.remove(person)
        }
        loadNextPerson()
    }

    private fun loadNextPerson() {
        if (people.isNotEmpty()) {
            _person.value = people.firstOrNull()
        } else {
            _person.value = null // Si no hay más personas, establece en null
        }
    }

    fun getLikedPeople(): List<Person> = likedPeople
}
