package com.example.mynirvana.presentation.activities.pomodoros.pomodoroTimerActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mynirvana.R
import com.example.mynirvana.domain.pomodoro.model.Pomodoro
import com.example.mynirvana.domain.timer.Timer
import com.example.mynirvana.presentation.activities.pomodoros.PomodoroTimerState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PomodoroTimerViewModel @Inject constructor(
    private val timer: Timer,
    private val musicPlayer: com.example.mynirvana.domain.mediaPlayer.MusicPlayer
) : ViewModel() {

    private var _remainingTime: MutableLiveData<Long> = MutableLiveData<Long>()
    val remainingTime: LiveData<Long>
        get() = _remainingTime

    private var _pomodoroTimerState: MutableLiveData<PomodoroTimerState> =
        MutableLiveData<PomodoroTimerState>()
    val pomodoroTimerState: LiveData<PomodoroTimerState>
        get() = _pomodoroTimerState

    private var _currentCircleState: MutableLiveData<Int> = MutableLiveData<Int>()
    val currentCircleState: MutableLiveData<Int>
        get() = _currentCircleState

    private var _isPomodoroCompleted: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    val isPomodoroCompleted: LiveData<Boolean>
        get() = _isPomodoroCompleted

    private lateinit var providedPomodoro: Pomodoro

    fun initViewModel(pomodoro: Pomodoro) {
        providedPomodoro = pomodoro

        viewModelScope.launch {
            _pomodoroTimerState.postValue(PomodoroTimerState.Work)
            _currentCircleState.postValue(1)
            _isPomodoroCompleted.postValue(false)

            timer.secondsRemaining.collect {
                _remainingTime.postValue(it)
                if (it == 0L) {
                    changePomodoroTimerState()
                }
            }
        }
    }


    private var counterOfCircles = 0.0

    private fun changePomodoroTimerState() {
        startSwooshSound()
        counterOfCircles += 0.5
        if (counterOfCircles % 1 == 0.0) {
            _currentCircleState.postValue(_currentCircleState.value?.plus(1))
        }

        if (counterOfCircles == providedPomodoro.quantityOfCircles.toDouble()) {
            _isPomodoroCompleted.value = true
        }

        when (pomodoroTimerState.value) {
            PomodoroTimerState.Work -> {
                _pomodoroTimerState.postValue(PomodoroTimerState.Relax)
            }

            PomodoroTimerState.Relax -> {
                _pomodoroTimerState.postValue(PomodoroTimerState.Work)
            }
        }

        stopTimer(true)
        startTimer(getValueOfSecondsForNextPomodoroTimerState())
    }

    fun startTimer(totalTimeInSeconds: Long) {
        timer.startTimer(totalTimeInSeconds)
    }

    fun stopTimer(isCanceled: Boolean = false) {
        timer.pauseTimer(isCanceled)
    }

    fun skipCurrentState() {
        changePomodoroTimerState()
    }

    private fun startSwooshSound() {
        musicPlayer.startSound(R.raw.swoosh_sound)
    }

    private fun getValueOfSecondsForNextPomodoroTimerState(): Long =
        when (pomodoroTimerState.value) {
            PomodoroTimerState.Work -> providedPomodoro.relaxTimeInSeconds
            else -> providedPomodoro.workTimeInSeconds
        }

}