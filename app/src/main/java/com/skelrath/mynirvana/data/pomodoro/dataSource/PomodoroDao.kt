package com.skelrath.mynirvana.data.pomodoro.dataSource

import androidx.room.*
import com.skelrath.mynirvana.domain.pomodoro.model.Pomodoro
import kotlinx.coroutines.flow.Flow

@Dao
interface PomodoroDao {

    @Query("SELECT * FROM pomodoro")
    fun getPomodoros(): Flow<List<Pomodoro>>


    @Query("SELECT * FROM pomodoro WHERE id = :id")
    suspend fun getPomodoroById(id: Int): Pomodoro?


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPomodoro(pomodoro: Pomodoro)

    @Delete
    suspend fun deletePomodoro(pomodoro: Pomodoro)
}