package com.example.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.schedule.databinding.FragmentRootBinding

class RootFragment: Fragment() {

    private var _binding: FragmentRootBinding? = null
    private val binding: FragmentRootBinding
        get() = requireNotNull(_binding)

    private val scheduleAdapter = ScheduleAdapter()
    private var scheduleSystem: ScheduleSystem = ScheduleSystem()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRootBinding.inflate(
            inflater,
            container,
            false)

        binding.bnvNav.setOnItemSelectedListener {
                item ->
            when(item.itemId){
                R.id.it_today -> {
                    scheduleAdapter.submitList(scheduleSystem.getDayList())
                }
                else -> {
                    scheduleAdapter.submitList(scheduleSystem.getWeekList())
                }
            }
            true
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding.rvBase){
            this.layoutManager = LinearLayoutManager(requireContext())
            this.adapter = scheduleAdapter
            addItemDecoration(ScheduleItemDecoration(scheduleSystem.getSelectedDay()))
        }
        scheduleAdapter.submitList(scheduleSystem.getDayList())
    }
}