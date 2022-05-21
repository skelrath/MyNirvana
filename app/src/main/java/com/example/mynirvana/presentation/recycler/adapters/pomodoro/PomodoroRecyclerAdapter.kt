package com.example.mynirvana.presentation.recycler.adapters.pomodoro

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mynirvana.databinding.LayoutPomodoroListItemBinding
import com.example.mynirvana.domain.meditations.readyMeditationsData.GetResourceIdOfBigPictureButtonForSmall
import com.example.mynirvana.domain.pomodoro.model.Pomodoro
import com.example.mynirvana.presentation.recycler.onClickListeners.pomodoros.PomodoroOnClickListener
import com.example.mynirvana.presentation.timeConvertor.TimeWorker

class PomodoroRecyclerAdapter(
    private val items: List<Pomodoro>,
    private val actionListener: PomodoroOnClickListener
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemBinding = LayoutPomodoroListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PomodoroViewHolder(itemBinding, actionListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is PomodoroViewHolder -> holder.bind(items[position])
        }
    }

    override fun getItemCount(): Int =
        items.size


    class PomodoroViewHolder(
        private val itemBinding: LayoutPomodoroListItemBinding,
        private val actionListener: PomodoroOnClickListener
    ) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(pomodoro: Pomodoro) {
            with(itemBinding) {
                pomodoroTimerNameTV.text = pomodoro.name

                quanitityOfCirclesTV.text =
                    "${pomodoro.quantityOfCircles} ${keyWordForQuantityOfPomodoros(pomodoro.quantityOfCircles)}"

                workRelaxTimeTV.text =
                    "${TimeWorker.convertTimeFromSecondsToMinutesFormatWithoutTimeWord(pomodoro.workTimeInSeconds)} / ${
                        TimeWorker.convertTimeFromSecondsToMinutesFormatWithoutTimeWord(
                            pomodoro.relaxTimeInSeconds
                        )
                    } минут"

                GetResourceIdOfBigPictureButtonForSmall.getResourceIdForMiniButton(
                    pomodoro.imageResourceId
                )?.let {
                    backgroundImage.setImageResource(
                        it
                    )
                }

                itemBinding.root.setOnClickListener {
                    actionListener.onPomodoroStart(pomodoro)
                }

                pomodoroOnRevert()
                if (pomodoro.isPomodoroCanBeDeleted) {
                    itemBinding.root.setOnLongClickListener {
                        pomodoroOnDelete(pomodoro)
                        true
                    }
                }
            }
        }

        private fun keyWordForQuantityOfPomodoros(quantity: Int): String =
            when (quantity) {
                1 -> "круг"
                2, 3, 4 -> "круга"
                else -> "кругов"
            }

        private fun pomodoroOnRevert() {
            with(itemBinding) {
                shadingLayout.visibility = View.GONE
            }
        }

        private fun pomodoroOnDelete(pomodoro: Pomodoro) {

            with(itemBinding) {
                shadingLayout.visibility = View.VISIBLE
                shadingLayout.setOnClickListener {
                    actionListener.onPomodoroDelete(pomodoro)
                }
            }
        }


    }
}
