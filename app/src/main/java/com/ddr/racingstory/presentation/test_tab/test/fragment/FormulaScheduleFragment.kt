package com.ddr.racingstory.presentation.test_tab.test.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.ddr.racingstory.R
import com.ddr.racingstory.databinding.FragmentFormulaScheduleBinding
import com.ddr.racingstory.presentation.main.CompetitionAdapter
import com.ddr.racingstory.presentation.test_tab.test.FormulaViewModel
import com.ddr.racingstory.presentation.test_tab.test.adapter.FormulaScheduleAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FormulaScheduleFragment : Fragment() {

    private val viewModel by viewModels<FormulaViewModel>()
    private lateinit var adapterFormula: FormulaScheduleAdapter
    private var _binding: FragmentFormulaScheduleBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFormulaScheduleBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRv()
        viewModel.getSchedule()
        observe()
    }

    private fun observe(){
        viewModel.liveDataSchedule.observe(viewLifecycleOwner){
            adapterFormula.setData(it)
        }
    }

    private fun initRv() {
        adapterFormula = FormulaScheduleAdapter()
        binding.rvScheduleFormula.apply {
            setHasFixedSize(true)
            adapter = adapterFormula
        }
    }
}