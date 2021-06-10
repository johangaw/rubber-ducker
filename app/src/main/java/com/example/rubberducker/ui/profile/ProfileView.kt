package com.example.rubberducker.ui.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rubberducker.TagSelect
import com.example.rubberducker.ui.model.Tag


@Composable
fun LiveProfileScreen() {
    var tags by remember { mutableStateOf<List<Tag>>(emptyList()) }

    Column(Modifier.padding(16.dp)) {
        TagSelect(tags) { tags = it }
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
