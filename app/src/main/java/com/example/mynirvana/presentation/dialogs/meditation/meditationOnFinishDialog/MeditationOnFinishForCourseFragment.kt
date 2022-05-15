package com.example.mynirvana.presentation.dialogs.meditation.meditationOnFinishDialog

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.mynirvana.R
import com.example.mynirvana.databinding.FragmentMeditationOnFinishForCourseBinding
import com.example.mynirvana.presentation.activities.meditations.meditationTimerActivity.MeditationOnFinishFragmentCallback


class MeditationOnFinishForCourseFragment : DialogFragment() {

    companion object {
        var isDialogResumed: Boolean = false
    }

    private lateinit var binding: FragmentMeditationOnFinishForCourseBinding
    private lateinit var callback: MeditationOnFinishFragmentCallback

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.BottomSheetDialog)
    }

    fun provideCallback(callback: MeditationOnFinishFragmentCallback) {
        this.callback = callback
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        isDialogResumed = true
        binding = FragmentMeditationOnFinishForCourseBinding.inflate(inflater)
        initButtons()
        return binding.root
    }

    private fun initButtons() {
        with(binding) {
            backToCourseActivity.setOnClickListener {
                callback.meditationOnFinishUserChoice(false)
                this@MeditationOnFinishForCourseFragment.dismiss()
            }
            backToHomeFragmentInMeditationOnFinishForCourse.setOnClickListener {
                callback.meditationOnFinishUserChoice(true)
                this@MeditationOnFinishForCourseFragment.dismiss()
            }
        }
    }

    override fun onDismiss(dialog: DialogInterface) {
        callback.meditationOnFinishFragmentDestroyed()
        isDialogResumed = false
        super.onDismiss(dialog)
    }


}