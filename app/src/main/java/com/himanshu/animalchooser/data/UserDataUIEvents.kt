package com.himanshu.animalchooser.data

sealed class UserDataUIEvents() {
    data class UserNameEntered(val name: String) : UserDataUIEvents()
    data class AnimalSelected(val animalName: String) : UserDataUIEvents()
}