package com.skelrath.mynirvana.domain.pomodoro.useCases

data class PomodoroUseCases(
    val addPomodoroUseCase: AddPomodoroUseCase,
    val deletePomodoroUseCase: DeletePomodoroUseCase,
    val getPomodorosUseCase: GetPomodorosUseCase
)