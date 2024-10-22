package com.example.schedule.viewmodel

import android.graphics.Canvas
import android.graphics.Paint
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.schedule.R
import com.example.schedule.model.Day

class ScheduleItemDecoration(
    private val selectedDay: Day
) : RecyclerView.ItemDecoration() {

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        val paint = Paint()
        val left = 15
        val right = parent.width - 15

        for (i in 0 until parent.childCount) {
            val child = parent.getChildAt(i)
            if(parent.getChildViewHolder(child) is ScheduleAdapter.DayViewHolder)
            {
                if(child.findViewById<TextView>(R.id.tv_day).text == selectedDay.ru)
                    paint.color = ContextCompat.getColor(parent.context, R.color.selectedDay)
                else
                    paint.color = ContextCompat.getColor(parent.context, R.color.day)
            } else{
                paint.color = ContextCompat.getColor(parent.context, R.color.lesson)
            }
            val top = child.top + 10
            val bottom = child.bottom - 10

            c.drawRect(left.toFloat(), top.toFloat(), right.toFloat(), bottom.toFloat(), paint)
        }
    }
}
