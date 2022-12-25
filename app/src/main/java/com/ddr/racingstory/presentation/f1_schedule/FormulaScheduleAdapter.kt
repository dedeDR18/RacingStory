package com.ddr.racingstory.presentation.f1_schedule

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ddr.core_model.Schedule
import com.ddr.racingstory.R
import com.ddr.racingstory.databinding.ItemScheduleFormulaBinding

/**
 * Created by Dede Dari Rahmadi on 25/12/22
 */

class FormulaScheduleAdapter : RecyclerView.Adapter<FormulaScheduleAdapter.ViewHolder>() {

    private val listData = mutableListOf<Schedule>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_schedule_formula, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentData = listData[position]
        holder.bind(currentData)
    }

    override fun getItemCount() = listData.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemScheduleFormulaBinding.bind(itemView)

        fun bind(data: Schedule){
            binding.apply {
                schedule = data
            }
        }
    }


}