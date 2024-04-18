package com.example.simplelivedataexample.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.simplelivedataexample.viewmodel.ExampleViewModel

@Composable
fun MyExample(viewModel: ExampleViewModel) {
    val number by viewModel.currentNumber.observeAsState(0)
    val isEven by viewModel.currentBoolean.observeAsState(false)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = if (isEven) "Even" else "Not Even", style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "$number", style = MaterialTheme.typography.h3)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            viewModel.incrementNumber()
        }) {
            Text(text = "+1")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMyExample() {
    val viewModel = ExampleViewModel()
    MyExample(viewModel = viewModel)
}
