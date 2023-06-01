package com.kirson.iwu

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.graphics.ImageBitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kirson.iwu.entities.MatchProfile
import com.kirson.iwu.entities.NewsItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainModel @Inject constructor() : ViewModel() {

    private val _likedPets = mutableStateListOf<MatchProfile>()
    val likedPets: SnapshotStateList<MatchProfile>
        get() = _likedPets

    private val _profilePhoto = mutableStateOf<ImageBitmap?>(null)
    val profilePhoto: State<ImageBitmap?>
        get() = _profilePhoto

    private val _selectedNews = mutableStateOf<NewsItem?>(null)
    val selectedNews: State<NewsItem?>
        get() = _selectedNews


    fun addLikedPet(pet: MatchProfile) {
        viewModelScope.launch {
            _likedPets.add(pet)
        }
    }

    fun setProfilePhoto(chosenPhoto: ImageBitmap) {
        _profilePhoto.value = chosenPhoto
    }

    fun setNews(news: NewsItem) {
        _selectedNews.value = news
    }

}