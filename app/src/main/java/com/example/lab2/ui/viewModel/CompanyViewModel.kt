package com.example.lab2.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab2.data.repository.CompanyRepository
import com.example.lab2.data.model.Company
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CompanyViewModel(
    private val repository: CompanyRepository = CompanyRepository()
) : ViewModel() {

    private val _companies = MutableStateFlow<List<Company>>(emptyList())
    val companies: StateFlow<List<Company>> = _companies

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    init {
        fetchCompanies() // Initial fetch
    }

    fun fetchCompanies() { // Make this function public so it can be called again
        viewModelScope.launch {
            _isLoading.value = true // Set loading state
            repository.fetchCompanies(
                onSuccess = { companyList ->
                    _companies.value = companyList
                    _isLoading.value = false
                },
                onFailure = { error ->
                    _errorMessage.value = error
                    _isLoading.value = false
                }
            )
        }
    }
}