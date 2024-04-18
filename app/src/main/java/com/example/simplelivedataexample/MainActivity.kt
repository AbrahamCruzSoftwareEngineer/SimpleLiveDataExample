package com.example.simplelivedataexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.simplelivedataexample.ui.composables.MyExample
import com.example.simplelivedataexample.ui.theme.SimpleLiveDataExampleTheme
import com.example.simplelivedataexample.viewmodel.ExampleViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleLiveDataExampleTheme {
                val exampleViewModel = ViewModelProvider(this)[ExampleViewModel::class.java]
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyExample(exampleViewModel)
                }
            }
        }
    }
}