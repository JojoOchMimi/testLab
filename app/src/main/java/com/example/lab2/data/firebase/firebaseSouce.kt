package com.example.lab2.data.firebase

import android.util.Log
import com.example.lab2.data.model.Company
import com.google.firebase.database.*

class FirebaseSource {
    private val database: DatabaseReference = FirebaseDatabase.getInstance().getReference("companies")

    fun fetchCompanies(onSuccess: (List<Company>) -> Unit, onFailure: (String) -> Unit) {
        val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val companyList = snapshot.children.mapNotNull { it.getValue(Company::class.java) }
                Log.d("FirebaseSource", "Data fetched successfully: ${companyList.size} items")
                onSuccess(companyList)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("FirebaseSource", "Firebase data read failed: ${error.message}")
                onFailure("Firebase data read failed: ${error.message}")
            }

        }

        // Change this to use addListenerForSingleValueEvent
        Log.d("FirebaseSource", "Fetching data from Firebase database reference")
        database.addListenerForSingleValueEvent(listener)
    }
}
