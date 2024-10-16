package com.example.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.replace
import com.example.schedule.databinding.FragmentRootBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class RootFragment: Fragment() {

    private var _binding: FragmentRootBinding? = null
    private val binding: FragmentRootBinding
        get() = requireNotNull(_binding)

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
                        childFragmentManager
                            .beginTransaction()
                            .replace(binding.fram.id, TodayFragment())
                            .commit()
                        true
                    }
                    R.id.it_week -> {
                        childFragmentManager
                            .beginTransaction()
                            .replace(binding.fram.id, WeekFragment())
                            .commit()
                        true
                    }
                    else -> false
                }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }
}