package com.skelrath.mynirvana.domain.meditations.usecases.meditationCoursesUseCases

import com.skelrath.mynirvana.R
import com.skelrath.mynirvana.domain.meditations.model.meditation.Meditation
import com.skelrath.mynirvana.domain.meditations.model.meditationCourse.MeditationCourse
import com.skelrath.mynirvana.domain.meditations.repository.MeditationCoursesRepository

class CreateMeditationCoursesUseCase(private val meditationCoursesRepository: MeditationCoursesRepository) {
    suspend fun invoke() {
        val meditationCourses: List<MeditationCourse> = listOf(
            MeditationCourse(
                name = "Для новичков",
                meditationList = listOf(
                    Meditation(
                        name = "Первая медитация",
                        time = 5,
                        imageResourceId = R.drawable.ic_rectangle_green,
                        backgroundSoundResourceId = R.raw.fire_sound,
                        endSoundResourceId = R.raw.guitar_sound,
                        isMeditationCanBeDeleted = false,
                        isMeditationCanBeRestarted = false
                    ),
                    Meditation(
                        name = "Вторая медитация",
                        time = 3,
                        imageResourceId = R.drawable.ic_rectangle_green,
                        backgroundSoundResourceId = R.raw.fire_sound,
                        endSoundResourceId = R.raw.guitar_sound,
                        isMeditationCanBeDeleted = false,
                        isMeditationCanBeRestarted = false
                    ),
                    Meditation(
                        name = "Третья медитация",
                        time = 3,
                        imageResourceId = R.drawable.ic_rectangle_green,
                        backgroundSoundResourceId = R.raw.fire_sound,
                        endSoundResourceId = R.raw.guitar_sound,
                        isMeditationCanBeDeleted = false,
                        isMeditationCanBeRestarted = false
                    ),
                    Meditation(
                        name = "Четвертая медитация",
                        time = 3,
                        imageResourceId = R.drawable.ic_rectangle_green,
                        backgroundSoundResourceId = R.raw.fire_sound,
                        endSoundResourceId = R.raw.guitar_sound,
                        isMeditationCanBeDeleted = false,
                        isMeditationCanBeRestarted = false
                    )
                ),
                imageResourceId = R.drawable.man_background
            ),
            MeditationCourse(
                name = "Осознанность",
                meditationList = listOf(
                    Meditation(
                        name = "Первая медитация",
                        time = 420,
                        imageResourceId = R.drawable.ic_rectangle_green,
                        backgroundSoundResourceId = R.raw.fire_sound,
                        endSoundResourceId = R.raw.guitar_sound,
                        isMeditationCanBeDeleted = false,
                        isMeditationCanBeRestarted = false
                    ),
                    Meditation(
                        name = "Вторая медитация",
                        time = 480,
                        imageResourceId = R.drawable.ic_rectangle_green,
                        backgroundSoundResourceId = R.raw.fire_sound,
                        endSoundResourceId = R.raw.guitar_sound,
                        isMeditationCanBeDeleted = false,
                        isMeditationCanBeRestarted = false
                    ),
                    Meditation(
                        name = "Третья медитация",
                        time = 540,
                        imageResourceId = R.drawable.ic_rectangle_green,
                        backgroundSoundResourceId = R.raw.fire_sound,
                        endSoundResourceId = R.raw.guitar_sound,
                        isMeditationCanBeDeleted = false,
                        isMeditationCanBeRestarted = false
                    ),
                    Meditation(
                        name = "Четвертая медитация",
                        time = 720,
                        imageResourceId = R.drawable.ic_rectangle_green,
                        backgroundSoundResourceId = R.raw.fire_sound,
                        endSoundResourceId = R.raw.guitar_sound,
                        isMeditationCanBeDeleted = false,
                        isMeditationCanBeRestarted = false
                    ),
                    Meditation(
                        name = "Пятая медитация",
                        time = 720,
                        imageResourceId = R.drawable.ic_rectangle_green,
                        backgroundSoundResourceId = R.raw.fire_sound,
                        endSoundResourceId = R.raw.guitar_sound,
                        isMeditationCanBeDeleted = false,
                        isMeditationCanBeRestarted = false
                    )
                ),
                imageResourceId = R.drawable.flower_background
            ), MeditationCourse(
                name = "Тревожность",
                meditationList = listOf(
                    Meditation(
                        name = "Первая медитация",
                        time = 600,
                        imageResourceId = R.drawable.ic_rectangle_green,
                        backgroundSoundResourceId = R.raw.fire_sound,
                        endSoundResourceId = R.raw.guitar_sound,
                        isMeditationCanBeDeleted = false,
                        isMeditationCanBeRestarted = false
                    ),
                    Meditation(
                        name = "Вторая медитация",
                        time = 600,
                        imageResourceId = R.drawable.ic_rectangle_green,
                        backgroundSoundResourceId = R.raw.fire_sound,
                        endSoundResourceId = R.raw.guitar_sound,
                        isMeditationCanBeDeleted = false,
                        isMeditationCanBeRestarted = false
                    ),
                    Meditation(
                        name = "Третья медитация",
                        time = 900,
                        imageResourceId = R.drawable.ic_rectangle_green,
                        backgroundSoundResourceId = R.raw.fire_sound,
                        endSoundResourceId = R.raw.guitar_sound,
                        isMeditationCanBeDeleted = false,
                        isMeditationCanBeRestarted = false
                    ),
                    Meditation(
                        name = "Четвертая медитация",
                        time = 900,
                        imageResourceId = R.drawable.ic_rectangle_green,
                        backgroundSoundResourceId = R.raw.fire_sound,
                        endSoundResourceId = R.raw.guitar_sound,
                        isMeditationCanBeDeleted = false,
                        isMeditationCanBeRestarted = false
                    ),
                    Meditation(
                        name = "Пятая медитация",
                        time = 900,
                        imageResourceId = R.drawable.ic_rectangle_green,
                        backgroundSoundResourceId = R.raw.fire_sound,
                        endSoundResourceId = R.raw.guitar_sound,
                        isMeditationCanBeDeleted = false,
                        isMeditationCanBeRestarted = false
                    )
                ),
                imageResourceId = R.drawable.fire_background

            ), MeditationCourse(
                name = "Снять стресс",
                meditationList = listOf(
                    Meditation(
                        name = "Первая медитация",
                        time = 600,
                        imageResourceId = R.drawable.ic_rectangle_green,
                        backgroundSoundResourceId = R.raw.fire_sound,
                        endSoundResourceId = R.raw.guitar_sound,
                        isMeditationCanBeDeleted = false,
                        isMeditationCanBeRestarted = false
                    ),
                    Meditation(
                        name = "Вторая медитация",
                        time = 600,
                        imageResourceId = R.drawable.ic_rectangle_green,
                        backgroundSoundResourceId = R.raw.fire_sound,
                        endSoundResourceId = R.raw.guitar_sound,
                        isMeditationCanBeDeleted = false,
                        isMeditationCanBeRestarted = false
                    ),
                    Meditation(
                        name = "Третья медитация",
                        time = 900,
                        imageResourceId = R.drawable.ic_rectangle_green,
                        backgroundSoundResourceId = R.raw.fire_sound,
                        endSoundResourceId = R.raw.guitar_sound,
                        isMeditationCanBeDeleted = false,
                        isMeditationCanBeRestarted = false
                    ),
                    Meditation(
                        name = "Четвертая медитация",
                        time = 900,
                        imageResourceId = R.drawable.ic_rectangle_green,
                        backgroundSoundResourceId = R.raw.fire_sound,
                        endSoundResourceId = R.raw.guitar_sound,
                        isMeditationCanBeDeleted = false,
                        isMeditationCanBeRestarted = false
                    ),
                    Meditation(
                        name = "Пятая медитация",
                        time = 900,
                        imageResourceId = R.drawable.ic_rectangle_green,
                        backgroundSoundResourceId = R.raw.fire_sound,
                        endSoundResourceId = R.raw.guitar_sound,
                        isMeditationCanBeDeleted = false,
                        isMeditationCanBeRestarted = false
                    )
                ),
                imageResourceId = R.drawable.water_background
            )
        )

        for (meditationCourse in meditationCourses) {
            meditationCoursesRepository.insertMeditationCourse(meditationCourse)
        }

    }
}