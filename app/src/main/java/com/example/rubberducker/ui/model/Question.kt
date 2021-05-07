package com.example.rubberducker.ui.model

import com.example.rubberducker.ui.model.Tag

data class Question(
    val title: String,
    val abstract: String,
    val tags: List<Tag>,
)