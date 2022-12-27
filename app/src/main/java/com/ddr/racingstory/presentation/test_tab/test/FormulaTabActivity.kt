package com.ddr.racingstory.presentation.test_tab.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.addCallback
import androidx.viewpager2.widget.ViewPager2
import com.ddr.racingstory.R
import com.ddr.racingstory.presentation.test_tab.test.adapter.ViewPagerAdapterFormula
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FormulaTabActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formula_tab)

        val tabLayout = findViewById<TabLayout>(R.id.tabFormula)
        val viewPager = findViewById<ViewPager2>(R.id.vpFormula)
        findViewById<Button>(R.id.btnBack).setOnClickListener {
            onBackPressed()
        }

        val adapterFormula = ViewPagerAdapterFormula(supportFragmentManager, lifecycle)

        viewPager.adapter = adapterFormula

        TabLayoutMediator(tabLayout, viewPager){ tabs, position ->
            when(position){
                0 -> tabs.text = "Schedule"
                1 -> tabs.text = "Standings"
                else -> {

                }
            }
        }.attach()


    }


    override fun onBackPressed() {
        onBackPressedDispatcher.onBackPressed()
    }




}