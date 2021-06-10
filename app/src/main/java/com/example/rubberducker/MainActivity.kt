package com.example.rubberducker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.rubberducker.ui.discussion.*
import com.example.rubberducker.ui.profile.LiveProfileScreen
import com.example.rubberducker.ui.question.QuestionView
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

val mockCandidates = DuckCandidates(
  listOf(
    DuckCandidate(
      "Kalle Anka",
      Ranking.create(52.3f),
      Availability.UNAVAILABLE),
    DuckCandidate(
        "Arne Anka",
        Ranking.create(29.2f),
        Availability.AVAILABLE)
  ))

@ExperimentalMaterialApi
@Preview(showBackground = true, device = Devices.PIXEL_4_XL, showSystemUi = true)
@Composable
fun DefaultPreview() {
    RubberDuckerTheme {
//        QuestionView()
        DuckPoolView(candidates = mockCandidates)
//        LiveProfileScreen()
    }
}