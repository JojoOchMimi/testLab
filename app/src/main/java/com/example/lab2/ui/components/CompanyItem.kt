package com.example.lab2.ui.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.lab2.data.model.Company
import androidx.compose.foundation.text.ClickableText
import androidx.compose.ui.text.SpanStyle
import com.example.lab2.ui.theme.DarkGreen

@Composable
fun CompanyItem(company: Company) {
    val context = LocalContext.current

    Column(modifier = Modifier.padding(8.dp)) {
        Text(text = "${company.id +1 }:  ${company.title}",
            style = MaterialTheme.typography.headlineMedium,
            color = DarkGreen)
        Text(text = "City: ${company.city}",
            color = DarkGreen)

        // Make the website link clickable
        ClickableText(
            text = AnnotatedString(
                text = "Website: ${company.webpage}",
                spanStyles = listOf(
                    AnnotatedString.Range(
                        item = SpanStyle(textDecoration = TextDecoration.Underline),
                        start = 9,
                        end = 9 + company.webpage.length
                    )
                )
            ),
            style = MaterialTheme.typography.bodyLarge.copy(color = MaterialTheme.colorScheme.primary),
            onClick = {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(company.webpage))
                context.startActivity(intent)
            }
        )
    }
}

