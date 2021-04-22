package com.example.rubberducker

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                .background(Color.Cyan)) {
            Text(tag.name)
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
            var visibleTags by remember { mutableStateOf(listOf<Tag>()) }
            TagSelect(visibleTags, {visibleTags = it})
        }
    }
}