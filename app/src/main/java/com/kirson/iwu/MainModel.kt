package com.kirson.iwu

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kirson.iwu.entities.MatchProfile
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainModel @Inject constructor() : ViewModel() {

    private val _likedPets = mutableStateListOf<MatchProfile>()
    val likedPets: SnapshotStateList<MatchProfile>
        get() = _likedPets



    fun addLikedPet(pet: MatchProfile) {
        viewModelScope.launch {
            _likedPets.add(pet)
        }
    }

}