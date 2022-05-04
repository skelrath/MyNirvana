package com.example.mynirvana.presentation.activities.meditationTimerActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynirvana.domain.mediaPlayer.MeditationMediaPlayer
import com.example.mynirvana.domain.timer.Timer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MeditationTimerViewModel @Inject constructor(
    private val timer: Timer, private val meditationMediaPlayer: MeditationMediaPlayer
) : ViewModel() {

    private var _remainingTime: MutableLiveData<Long> = MutableLiveData<Long>()
    val remainingTime: LiveData<Long>
        get() = _remainingTime

    private var currentBackgroundSound: Int = 0
    private var currentEndSound: Int = 0

    fun providesBackgroundSound(currentBackgroundSound: Int) {
        this.currentBackgroundSound = currentBackgroundSound
    }

    fun providesEndSound(currentEndSound: Int) {
        this.currentEndSound = currentEndSound
    }

    init {
        viewModelScope.launch {
            timer.secondsRemaining.collect {
                _remainingTime.postValue(it)
                if (it == 0L) {
                    pauseBackgroundSound()
                    startEndSound(currentEndSound)
                }
            }
        }
    }

    fun startTimer(totalTimeInSeconds: Long) {
        timer.startTimer(totalTimeInSeconds)
    }

    fun pauseTimer() {
        timer.pauseTimer()
    }

    fun startBackgroundSound(soundResourceId: Int) {
        meditationMediaPlayer.startBackgroundSound(soundResourceId)
    }

    private fun startEndSound(soundResourceId: Int) {
        meditationMediaPlayer.startEndSound(soundResourceId)
    }

    fun pauseBackgroundSound() {
        meditationMediaPlayer.stopSound()
    }

    fun stopMeditationMediaPlayer() {
        meditationMediaPlayer.stopSound()
    }
}