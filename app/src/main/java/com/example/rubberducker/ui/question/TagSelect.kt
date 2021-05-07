package com.example.rubberducker

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rubberducker.ui.model.Tag
import com.example.rubberducker.ui.theme.RubberDuckerTheme

val staticTags = listOf(
    Tag("Kotlin"),
    Tag("Java"),
    Tag("F#"),
    Tag("Mongo DB"),
    Tag("C++"),
    Tag("C#"),
    Tag("C"),
    Tag("Assembly"),
)

fun addNewTag(tag: Tag, selectedTags: List<Tag>, searchState: MutableState<String>, visibleTagState: MutableState<List<Tag>>): List<Tag> {
    searchState.value = ""
    visibleTagState.value = listOf()
    return selectedTags.plus(tag)
}

fun removeTag(tag: Tag, selectedTags: List<Tag>): List<Tag> {
    return selectedTags - tag
}

@Composable
fun TagSelect(selectedTags: List<Tag>, onSelectedTagsChange: (List<Tag>) -> Unit) {
    var search = remember {
        mutableStateOf("")
    }
    var visibleTags = remember { mutableStateOf(listOf<Tag>()) }

    OutlinedTextField(
        value = search.value,
        onValueChange = { enteredTag ->
            search.value = enteredTag
            visibleTags.value = staticTags
                .filter { !selectedTags.contains(it) }
                .filter {
                if (search.value.length < 3) {
                    it.name.equals(search.value, ignoreCase = true)
                } else {
                    it.name.contains(search.value, ignoreCase = true)
                }
            }
        },
        label = { Text("Tags") }
    )

    for (tag in selectedTags) {
        Box(
            Modifier
                .padding(4.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.Cyan)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.width(16.dp))
                Text(tag.name)
                IconButton(onClick = { onSelectedTagsChange(removeTag(tag, selectedTags)) }) {
                    Icon(Icons.Default.Delete, contentDescription = null)
                }
            }
        }
    }

    for (tag in visibleTags.value) {
        Text(tag.name, modifier = Modifier.clickable { onSelectedTagsChange(addNewTag(tag, selectedTags, search, visibleTags)) })
    }
}

@ExperimentalMaterialApi
@Preview(showBackground = true, device = Devices.PIXEL_4_XL, showSystemUi = true)
@Composable
fun TagSelectPreview() {
    RubberDuckerTheme {
        Column {
            var visibleTags by remember { mutableStateOf(staticTags.take(3)) }
            TagSelect(visibleTags) { visibleTags = it }
        }
    }
}