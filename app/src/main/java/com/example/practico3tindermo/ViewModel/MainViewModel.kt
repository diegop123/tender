package com.example.practico3tindermo.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.practico3tindermo.Persona
import com.example.practico3tindermo.R

class MainViewModel : ViewModel() {

    private val _persona = MutableLiveData<Persona?>()
    val persona: LiveData<Persona?> = _persona

    private val people = mutableListOf(
        Persona("luis miguel ", listOf(R.drawable.persona1_imagen1, R.drawable.persona1_imagen2, R.drawable.persona1_imagen3)),
        Persona("arthur morgan", listOf(R.drawable.persona2_iamgen1, R.drawable.persona2_imagen2, R.drawable.persona2_imagen3)),
        Persona("henry cavil", listOf(R.drawable.persona3_imagen1, R.drawable.persona3_imagen2, R.drawable.persona3_imagen33)),
        Persona("kratos", listOf(R.drawable.persona4_imagen1, R.drawable.persona4_imagen2, R.drawable.persona4_imagen3)),
        Persona("henry cavil", listOf(R.drawable.persona3_imagen1, R.drawable.persona3_imagen2, R.drawable.persona3_imagen33)),
        Persona("henry cavil", listOf(R.drawable.persona3_imagen1, R.drawable.persona3_imagen2, R.drawable.persona3_imagen33)),
        Persona("arthur morgan", listOf(R.drawable.persona2_iamgen1, R.drawable.persona2_imagen2, R.drawable.persona2_imagen3)),
    )

    private val likedPeople = mutableListOf<Persona>()
    private var index = 0

    init {
        loadNextPerson()
    }

    fun likePerson() {
        _persona.value?.let { person ->
            likedPeople.add(person)
            people.remove(person)
        }
        loadNextPerson()
    }

    fun dislikePerson() {
        _persona.value?.let { person ->
            people.remove(person)
        }
        loadNextPerson()
    }

    private var currentIndex = 0

    private fun loadNextPerson() {
        if (people.isNotEmpty()) {
            _persona.value = people[currentIndex]
            currentIndex = (currentIndex + 1) % people.size // Incrementa y reinicia el índice al llegar al final
        } else {
            _persona.value = null
        }
    }

    fun getLikedPeople(): List<Persona> = likedPeople
}
