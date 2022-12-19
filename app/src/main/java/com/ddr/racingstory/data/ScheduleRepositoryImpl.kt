package com.ddr.racingstory.data

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.ddr.core_model.Competition
import com.ddr.core_model.Schedule
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import javax.inject.Inject

/**
 * Created by Dede Dari Rahmadi on 18/12/22
 */

class ScheduleRepositoryImpl @Inject constructor(
    val database: FirebaseDatabase
) : ScheduleRepository {

    companion object {
        const val MOTOGP_REFERENCE = "MotoGp"
        const val WSBK_REFERENCE = "WSBK"
        const val FORMULA1_REFERENCE = "F1"
        const val SCHEDULE_REFERENCE = "schedule"
    }

    override fun fetchScheduleMotogp(liveData: MutableLiveData<List<Schedule>>) {
        database.getReference(SCHEDULE_REFERENCE).child(MOTOGP_REFERENCE)
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val list = ArrayList<Schedule>()
                    for (item in snapshot.children) {
                        val competition = item.getValue(Schedule::class.java)
                        competition?.let {
                            list.add(it)
                        }
                        liveData.postValue(list)
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.d("MAIN", "error = ${error.message}")
                }

            })
    }

    override fun fetchScheduleWsbk(liveData: MutableLiveData<List<Schedule>>) {
        database.getReference(SCHEDULE_REFERENCE).child(WSBK_REFERENCE)
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val list = ArrayList<Schedule>()
                    for (item in snapshot.children) {
                        val competition = item.getValue(Schedule::class.java)
                        competition?.let {
                            list.add(it)
                        }
                        liveData.postValue(list)
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.d("MAIN", "error = ${error.message}")
                }

            })
    }

    override fun fetchScheduleFormula1(liveData: MutableLiveData<List<Schedule>>) {
        database.getReference(SCHEDULE_REFERENCE).child(FORMULA1_REFERENCE)
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val list = ArrayList<Schedule>()
                    for (item in snapshot.children) {
                        val competition = item.getValue(Schedule::class.java)
                        competition?.let {
                            list.add(it)
                        }
                        liveData.postValue(list)
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.d("MAIN", "error = ${error.message}")
                }

            })
    }

}