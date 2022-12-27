package com.ddr.racingstory.util

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ddr.core_model.Competition
import com.ddr.racingstory.presentation.main.CompetitionAdapter

/**
 * Created by Dede Dari Rahmadi on 12/12/22
 */
object BindingAdapters {

    @JvmStatic
    @BindingAdapter("setItems")
    fun setItems(recyclerView: RecyclerView, list: List<Competition>?) {
        (recyclerView.adapter as CompetitionAdapter).setData(list)
    }

    @JvmStatic
    @BindingAdapter("setDateDay")
    fun setDateDay(tv: TextView, fullDate: String){
        val arrayDate = fullDate.split("/")
        tv.text = arrayDate[0]
    }

    @JvmStatic
    @BindingAdapter("setDateMonth")
    fun setDateMonth(tv: TextView, fullDate: String){
        val arrayDate = fullDate.split("/")
        tv.text = arrayDate[1]
    }
}