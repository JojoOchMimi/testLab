package com.example.lab2.data.repository

import com.example.lab2.data.model.Company
import com.example.lab2.data.firebase.FirebaseSource

class CompanyRepository(private val firebaseSource: FirebaseSource = FirebaseSource()) {

    fun fetchCompanies(onSuccess: (List<Company>) -> Unit, onFailure: (String) -> Unit) {
        firebaseSource.fetchCompanies(onSuccess, onFailure)
    }
}