package com.example.schedule

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.schedule.databinding.ItemDayBinding
import com.example.schedule.databinding.ItemLessonBinding

class ScheduleAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listItems = mutableListOf<ScheduleItem>()

    fun submitList(list: List<ScheduleItem>){
        listItems = list.toMutableList()
    }

    override fun getItemViewType(position: Int): Int {
        return when(listItems[position]){
            is ScheduleLesson -> ScheduleViewType.LESSON
            is ScheduleDay -> ScheduleViewType.DAY
            else -> error("Unknown type of item in the list.")
        }.ordinal
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when(viewType){
            ScheduleViewType.LESSON.ordinal -> LessonViewHolder(
                ItemLessonBinding.inflate(
                    inflater,
                    parent,
                    false)

            )
            ScheduleViewType.DAY.ordinal -> DayViewHolder(
                ItemDayBinding.inflate(
                    inflater,
                    parent,
                    false)
            )
            else -> error("Unknown type of item in the list.")
        }
    }

    override fun getItemCount(): Int = listItems.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is LessonViewHolder -> holder.bind(listItems[position] as ScheduleLesson)
            is DayViewHolder -> holder.bind(listItems[position] as ScheduleDay)
        }
    }

    class LessonViewHolder(
        private val binding: ItemLessonBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(lesson: ScheduleLesson) {
            with(binding) {
                lesson.run {
                    tvTime.text = time
                    tvNameLesson.text = nameLesson
                    tvTypeLesson.text = typeLesson.ru
                }
            }
        }
    }

    class DayViewHolder(
        private val binding: ItemDayBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(day: ScheduleDay){
            with(binding){
                day.run {
                    tvDay.text = day.nameDay.ru
                }
            }
        }
    }
}