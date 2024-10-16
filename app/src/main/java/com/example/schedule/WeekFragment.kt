package com.example.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.schedule.databinding.FragmentWeekBinding

class WeekFragment: Fragment() {

    private var _binding: FragmentWeekBinding? = null
    private val binding: FragmentWeekBinding
        get() = requireNotNull(_binding)

    private val adapter = ScheduleAdapter()
    private val list = mutableListOf(
        ScheduleDay(Day.TUESDAY),
        ScheduleLesson("18:20-19:50",
            "Управление ИТ-проектами",
            TypeLesson.LECTURE),
        ScheduleLesson("19:55-21:25",
            "Управление ИТ-проектами",
            TypeLesson.PRACTICE),
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWeekBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.rvBase){
            this.layoutManager = LinearLayoutManager(context)
            this.adapter = this@WeekFragment.adapter
        }
        adapter.submitList(list)
    }

}