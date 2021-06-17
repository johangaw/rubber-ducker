package com.example.rubberducker.ui.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.rubberducker.R
import com.example.rubberducker.TagSelect
import com.example.rubberducker.staticTags
import com.example.rubberducker.ui.model.Tag


@Composable
fun RatingBar(
    rating: Int,
    activeIcon: @Composable () -> Unit,
    inactiveIcon: @Composable () -> Unit
) {
    Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
        repeat(5) {
            IconButton(onClick = {}) {
                if (it < rating) {
                    activeIcon()

                } else {
                    inactiveIcon()
                }
            }
        }
    }
}

@Composable
fun LiveProfileScreen() {
    var tags by remember { mutableStateOf<List<Tag>>(emptyList()) }
    var favoriteRating by remember { mutableStateOf(4) }
    var knowledgeRating by remember { mutableStateOf(2) }

    Column(Modifier.padding(16.dp)) {
        TagSelect(
            selectedTags = tags,
            onSelectedTagsChange = { tags = if (it.isEmpty()) it else listOf(it.last()) })

        RatingBar(
            favoriteRating,
            {
                Icon(
                    painterResource(id = R.drawable.outline_star_24),
                    contentDescription = ""
                )
            },
            {
                Icon(
                    painterResource(id = R.drawable.outline_star_border_24),
                    contentDescription = ""
                )
            }
        )

        RatingBar(
            knowledgeRating,
            {
                Icon(Icons.Default.Favorite, contentDescription = "")
            },
            {
                Icon(Icons.Default.FavoriteBorder, contentDescription = "")
            }
        )

//        OutlinedTextField(value = "", onValueChange = {}, label={ Text("select tag")})
//        OutlinedTextField(value = "", onValueChange = {}, label = { Text("Knowledge") })
//        OutlinedTextField(value = "", onValueChange = {}, label = { Text("Fun") })

//        TagSelect(tags) { tags = it }
        Spacer(modifier = Modifier.height(16.dp))
//        repeat(8) {
//            Row() {
//                OutlinedTextField(value = "", onValueChange = {})
//                OutlinedTextField(value = "", onValueChange = {}, label = { Text("Knowledge") })
//                OutlinedTextField(value = "", onValueChange = {}, label = { Text("Interest") })
//            }
//        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun LiveProfileScreenPreview() {
    LiveProfileScreen()
}
