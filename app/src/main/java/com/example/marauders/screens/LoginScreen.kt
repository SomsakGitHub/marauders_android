package com.example.marauders.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LoginScreen(){

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ){
        var text = ""

        Column {
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("username") }
            )

            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("password") }
            )
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview(){
    LoginScreen()
}