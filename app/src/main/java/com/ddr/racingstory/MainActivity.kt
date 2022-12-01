package com.ddr.racingstory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ddr.core_model.Competition
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var database: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = Firebase.database.reference

        getData()
    }

    private fun getData() {
        database.child("competition").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (item in snapshot.children) {
                    val competition = item.getValue(Competition::class.java)
                    Log.d("MAIN", "competition = ${competition?.name}")
                    Log.d("MAIN", "competition = ${competition?.id}")
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Log.d("MAIN", "error = ${error.message}")
            }

        })

    }
}