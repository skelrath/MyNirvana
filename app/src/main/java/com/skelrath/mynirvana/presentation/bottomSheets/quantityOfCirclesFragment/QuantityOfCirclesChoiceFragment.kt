package com.skelrath.mynirvana.presentation.bottomSheets.quantityOfCirclesFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.skelrath.mynirvana.R
import com.skelrath.mynirvana.databinding.FragmentQuantityOfCirclesChoiceBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class QuantityOfCirclesChoiceFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentQuantityOfCirclesChoiceBinding
    private var numberOfCircles = 0
    private var functionToLaunch: ((Int) -> Unit?)? = null

    fun provideLambdaCallback(functionToLaunch: (numberOfCircles: Int) -> Unit) {
        this.functionToLaunch = functionToLaunch
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.BottomSheetDialog)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuantityOfCirclesChoiceBinding.inflate(inflater)
        initCirclesPicker()
        return binding.root
    }

    private fun initCirclesPicker() {
        with(binding) {
            circlesNumberPicker.apply {
                minValue = 0
                maxValue = 10
            }
            circlesNumberPicker.setOnValueChangedListener { _, _, p2 ->
                functionToLaunch?.let { it(p2) }
            }
        }
    }
}
