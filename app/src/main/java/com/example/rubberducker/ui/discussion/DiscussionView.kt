package com.example.rubberducker.ui.discussion

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ListItem
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@ExperimentalMaterialApi
@Composable()
fun DiscussionScreen() {
    Column(Modifier.padding(16.dp)) {
        Text("Abstract asdbask jdaskd askjd aksjd asjkhdb askjd kjasdsa")
        Spacer(Modifier.height(16.dp))
        repeat(7) {
            ListItem(
                text = { Text("Name of person ${it}") },
                trailing = { Text("60%") },
                icon = {
                    if (it < 2) {
                        Icon(Icons.Default.Star, contentDescription = null)
                    }
                }
                // TODO indicate if duck has seen it
            )
        }
    }
}