package com.example.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.schedule.databinding.FragmentTodayBinding

class TodayFragment: Fragment() {

    private var _binding: FragmentTodayBinding? = null
    private val binding: FragmentTodayBinding
        get() = requireNotNull(_binding)

    private val adapter = ScheduleAdapter()
    private val list = mutableListOf(
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
        _binding = FragmentTodayBinding.inflate(
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
            this.adapter = this@TodayFragment.adapter
        }
        adapter.submitList(list)
    }
}