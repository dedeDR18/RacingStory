package com.ddr.racingstory.presentation.test_tab.test.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ddr.racingstory.presentation.test_tab.test.fragment.FormulaStandingsFragment
import com.ddr.racingstory.presentation.test_tab.test.fragment.FormulaScheduleFragment

/**
 * Created by Dede Dari Rahmadi on 26/12/22
 */

class ViewPagerAdapterFormula(fm: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fm, lifecycle) {
    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                FormulaScheduleFragment()
            }
            1 -> {
                FormulaStandingsFragment()
            }
            else -> {
                Fragment()
            }
        }
    }

}