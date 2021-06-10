package com.example.rubberducker.ui.discussion

import android.app.Dialog
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable()
fun DuckProfilePreview(candidate: DuckCandidate, onDismissReq: () -> Unit) {
  Dialog(onDismissRequest = {
    onDismissReq()
  }) {
    Box(modifier =
      Modifier
        .background(color = Color.White, shape = RectangleShape)
        .padding(32.dp)) {
      Text(text = candidate.name)
    }
  }
}