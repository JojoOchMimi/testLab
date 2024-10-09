package com.example.lab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab2.ui.screen.CompanyListScreen
import com.example.lab2.ui.screen.WelcomeScreen
import com.example.lab2.ui.theme.Lab2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab2Theme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "welcome") {
                    composable("welcome") {
                        WelcomeScreen(onNavigateToCompanyList = {
                            navController.navigate("companyList")
                        })
                    }
                    composable("companyList") {
                        CompanyListScreen(
                            onBackToWelcome = {
                                navController.popBackStack() // Navigate back to the welcome screen
                            }
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab2Theme {
        WelcomeScreen (onNavigateToCompanyList = {})
    }
}
