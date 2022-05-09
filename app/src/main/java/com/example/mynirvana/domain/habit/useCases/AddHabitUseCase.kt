package com.example.mynirvana.domain.habit.useCases

import com.example.mynirvana.domain.habit.model.Habit
import com.example.mynirvana.domain.habit.repository.HabitRepository

class AddHabitUseCase(private val habitRepository: HabitRepository) {
    suspend fun invoke(habit: Habit) = habitRepository.insertHabit(habit)
}