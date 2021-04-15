package com.example.rubberducker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rubberducker.ui.theme.RubberDuckerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RubberDuckerTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
//                    Greeting("Android")
                }
            }
        }
    }
}

data class Question(
    val title: String,
    val abstract: String,
    val tags: List<Tag>,
)

data class Tag(
    val name: String
)



@Composable
fun QuestionScreen() {
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

@Composable
fun TagSelect(selectedTags: List<Tag>, onSelectedTagsChange: (List<Tag>) -> Unit) {
    var search by remember {
        mutableStateOf("")
    }
    var visibleTags by remember { mutableStateOf(listOf<Tag>()) }

    OutlinedTextField(
        value = search,
        onValueChange = {
            search = it
            visibleTags = staticTags.filter {
                if (search.length < 3) {
                    it.name.equals(search, ignoreCase = true)
                } else {
                    it.name.contains(search, ignoreCase = true)
                }
            }
        },
        label = { Text("Tags") }
    )

    for (tag in selectedTags) {
        Box(Modifier.padding(4.dp).background(Color.Cyan)) {
            Text(tag.name)
        }
    }

    for (tag in visibleTags) {
        Text(tag.name, modifier = Modifier.clickable { onSelectedTagsChange(selectedTags.plus(tag)) })
    }
}

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

@Composable
fun LiveProfileScreen() {
    Column(Modifier.padding(16.dp)) {
        OutlinedTextField(value = "", onValueChange = {}, label = { Text("Tags") })
        Spacer(modifier = Modifier.height(16.dp))
        repeat(8) {
            Row() {
                OutlinedTextField(value = "", onValueChange = {})
                OutlinedTextField(value = "", onValueChange = {}, label = {Text("Knowledge")})
                OutlinedTextField(value = "", onValueChange = {}, label = {Text("Interest")})
            }
        }
    }
}



@ExperimentalMaterialApi
@Preview(showBackground = true, device = Devices.PIXEL_4_XL, showSystemUi = true)
@Composable
fun DefaultPreview() {
    RubberDuckerTheme {
        QuestionScreen()
//        DiscussionScreen()
//        LiveProfileScreen()
    }
}