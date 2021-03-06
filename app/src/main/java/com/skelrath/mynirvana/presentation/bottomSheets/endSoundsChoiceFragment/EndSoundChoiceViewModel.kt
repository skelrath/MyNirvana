package com.skelrath.mynirvana.presentation.bottomSheets.endSoundsChoiceFragment

import androidx.lifecycle.ViewModel
import com.skelrath.mynirvana.domain.endSounds.model.EndSound
import com.skelrath.mynirvana.domain.endSounds.ReadyEndSounds

class EndSoundChoiceViewModel : ViewModel() {

    fun getEndSounds(): List<EndSound> {
        val endSoundsList = mutableListOf<EndSound>()

        ReadyEndSounds.values().forEach {
            val icon = it.endSound.icon
            val sound = it.endSound.sound
            val name = it.endSound.name

            endSoundsList.add(EndSound(icon = icon, sound = sound, name = name))
        }

        return endSoundsList
    }

}