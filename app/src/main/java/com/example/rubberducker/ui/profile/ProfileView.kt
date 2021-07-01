package com.example.rubberducker.ui.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
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
    onRatingChange: (newRating: Int) -> Unit,
    activeIcon: @Composable () -> Unit,
    inactiveIcon: @Composable () -> Unit
) {
    Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
        repeat(5) {
            IconButton(onClick = { onRatingChange( it + 1) }) {
                if (it < rating) {
                    activeIcon()

                } else {
                    inactiveIcon()
                }
            }
        }
    }
}

data class Rating(val favourite: Int, val knowledge: Int)

data class Skill(val tag: Tag, var ratings: Rating)

@Composable
fun SkillEntry(skill: Skill, onSkillChange: (newSkill: Skill) -> Unit) {
    Card(Modifier.padding(8.dp)) {
        Column(Modifier.padding(8.dp)) {
            Text(skill.tag.name)
            RatingBar(
                skill.ratings.favourite,
                { onSkillChange(skill.copy(ratings = skill.ratings.copy(favourite = it))) },
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
                skill.ratings.knowledge,
                { onSkillChange(skill.copy(ratings = skill.ratings.copy(knowledge = it))) },
                {
                    Icon(Icons.Default.Favorite, contentDescription = "")
                },
                {
                    Icon(Icons.Default.FavoriteBorder, contentDescription = "")
                }
            )
        }
    }
}

@Composable
fun LiveProfileScreen() {
    var tags by remember { mutableStateOf<List<Tag>>(emptyList()) }

    var favoriteRating by remember { mutableStateOf(4) }
    var knowledgeRating by remember { mutableStateOf(2) }
    var skills by remember {
        mutableStateOf<List<Skill>>(
            listOf(Skill(Tag("C++"),
            ratings = Rating(favourite = favoriteRating, knowledge = knowledgeRating))))
    }

    Column(Modifier.padding(16.dp)) {
        TagSelect(
            selectedTags = tags,
            onSelectedTagsChange = { tags = if (it.isEmpty()) it else listOf(it.last()) })

        SkillEntry(skill = skills.first()) {
            newSkillWithRating -> skills = listOf(newSkillWithRating)
        }


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
