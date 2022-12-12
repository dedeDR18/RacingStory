package com.ddr.racingstory.presentation.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ddr.core_model.Competition
import com.ddr.racingstory.R
import com.ddr.racingstory.databinding.ItemCompetitionBinding

/**
 * Created by Dede Dari Rahmadi on 01/12/22
 */

class CompetitionAdapter : RecyclerView.Adapter<CompetitionAdapter.ViewHolder>() {

    private val listData = mutableListOf<Competition>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<Competition>?) {
        listData.clear()
        listData.addAll(data ?: emptyList())
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_competition, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentData = listData[position]
        holder.bind(currentData)
    }

    override fun getItemCount() = listData.size


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemCompetitionBinding.bind(itemView)
        fun bind(data: Competition) {
            binding.apply {
                title.text = data.name
            }
        }
    }
}