package com.example.rubberducker.ui.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun LiveProfileScreen() {
    Column(Modifier.padding(16.dp)) {
        OutlinedTextField(value = "", onValueChange = {}, label = { Text("Tags") })
        Spacer(modifier = Modifier.height(16.dp))
        repeat(8) {
            Row() {
                OutlinedTextField(value = "", onValueChange = {})
                OutlinedTextField(value = "", onValueChange = {}, label = { Text("Knowledge") })
                OutlinedTextField(value = "", onValueChange = {}, label = { Text("Interest") })
            }
        }
    }
}
