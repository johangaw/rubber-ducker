package com.example.rubberducker.ui.discussion

import android.app.Dialog
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Dialog

@Composable()
fun DuckProfilePreview(candidate: DuckCandidate) {
  Dialog(onDismissRequest = { /*TODO*/ }) {
    Text(text = "hejsan")
    Text(text = candidate.name)
  }
}