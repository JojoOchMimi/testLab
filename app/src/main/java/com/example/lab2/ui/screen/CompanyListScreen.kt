package com.example.lab2.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

import com.example.lab2.data.model.Company
import com.example.lab2.data.repository.CompanyRepository
import com.example.lab2.ui.components.CompanyItem
import androidx.compose.ui.Alignment
import com.example.lab2.ui.viewmodel.CompanyViewModel

@Composable
fun CompanyListScreen(
    modifier: Modifier = Modifier,
    viewModel: CompanyViewModel = viewModel(),
    onBackToWelcome: () -> Unit
) {
    // Trigger the fetchCompanies call only once when the Composable enters the composition

    val companies = viewModel.companies.collectAsState().value
    val isLoading = viewModel.isLoading.collectAsState().value
    val errorMessage = viewModel.errorMessage.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (isLoading) {
            CircularProgressIndicator()
        } else if (errorMessage != null) {
            Text(
                text = errorMessage ?: "An error occurred",
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.error
            )
        } else {
            LazyColumn(modifier = Modifier.weight(1f)) {
                items(companies) { company ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f) // Adjust card background color
                        ),
                        elevation = CardDefaults.cardElevation(2.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            CompanyItem(company = company)
                        }
                    }
                }
            }
        }

        // Back Button
        Button(
            onClick = onBackToWelcome,
            modifier = Modifier
                .padding(top = 16.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text("Back")
        }
    }
}