package com.example.lab2.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.example.lab2.ui.theme.DarkGreen

@Composable
fun WelcomeScreen(onNavigateToCompanyList: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                "Welcome to the Company List App!",
                style = MaterialTheme.typography.headlineLarge,
                textAlign = TextAlign.Center,
                color = DarkGreen
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onNavigateToCompanyList) {
                Text("Next")
            }
        }
    }
}