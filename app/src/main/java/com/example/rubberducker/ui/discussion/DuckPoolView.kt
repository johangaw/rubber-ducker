package com.example.rubberducker.ui.discussion

import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.util.*

@ExperimentalMaterialApi
@Composable()
fun DuckPoolView(candidates: DuckCandidates) {
    var focusedCandidate: MutableState<Optional<DuckCandidate>> = remember {
        mutableStateOf(
            Optional.empty()
        )
    }
    when (focusedCandidate.value.isPresent) {
        true -> DuckProfilePreview(
            candidate = focusedCandidate.value.get()
        ) {
            focusedCandidate.value = Optional.empty()
        }
    }
    var candidates = candidates.candidates.sortedByDescending { it.ranking }
    Column(Modifier.padding(16.dp)) {
        Text("Select an available duck to get help from")
        Spacer(Modifier.height(16.dp))
        candidates.forEach {
            ListItem(
                text = { Text("${it.name}") },
                trailing = { Text("${it.ranking}") },
                icon = {
                    if (it.availability == Availability.AVAILABLE) {
                        Icon(Icons.Default.Star, contentDescription = null)
                    }
                },
                modifier = Modifier.clickable {
                    focusedCandidate.value = Optional.of(it)
                }
            )
        }
    }
}