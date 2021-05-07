package com.example.rubberducker.ui.question

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rubberducker.TagSelect
import com.example.rubberducker.ui.model.Question


@Composable
fun QuestionView() {
    var question by remember {
        mutableStateOf(Question(title = "", abstract = "", tags = emptyList()))
    }

    Column(Modifier.padding(16.dp)) {
        OutlinedTextField(value = question.title, onValueChange = { question = question.copy(title = it)}, label = { Text("Title") })
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = question.abstract, onValueChange = {question = question.copy(abstract = it)}, label = { Text("Abstract") })
        Spacer(modifier = Modifier.height(16.dp))

        // search and select and create dropdown/modal
        TagSelect(selectedTags = question.tags, onSelectedTagsChange = {
            question = question.copy( tags = it)
        })

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            // ask for ducks that match question


            // navigate to DiscussionScreen with list

        }) {
            Text("Search")
        }
    }
}
