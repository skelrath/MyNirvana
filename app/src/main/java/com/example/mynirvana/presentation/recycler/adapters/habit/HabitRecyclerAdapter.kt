package com.example.mynirvana.presentation.recycler.adapters.habit

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mynirvana.R
import com.example.mynirvana.databinding.LayoutTaskListItemBinding

import com.example.mynirvana.domain.habit.model.Habit
import com.example.mynirvana.presentation.recycler.onClickListeners.habits.HabitOnClickListener

class HabitRecyclerAdapter(
    private val items: List<Habit>,
    private val actionListener: HabitOnClickListener
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemBinding =
            LayoutTaskListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return HabitViewHolder(itemBinding, actionListener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HabitViewHolder -> holder.bind(items[position])
        }
    }

    override fun getItemCount() = items.size


    class HabitViewHolder(
        private val itemBinding: LayoutTaskListItemBinding,
        private val actionListener: HabitOnClickListener
    ) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(habit: Habit) {
            with(itemBinding) {

                if (habit.isHabitCompleted) {
                    isCompletedImageButton.setImageResource(R.drawable.ic_is_completed_button)
                    nameOfTaskTV.apply {
                        paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                    }
                } else {
                    isCompletedImageButton.setImageResource(R.drawable.ic_is_not_completed_button)
                }

                isCompletedImageButton.setOnClickListener {
                    actionListener.onComplete(habit)
                }

                nameOfTaskTV.text = habit.name

                timeOfTaskTV.text = ""
            }
        }
    }
}