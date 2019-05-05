package com.farifam.siwasis.model
import com.google.gson.annotations.SerializedName

data class Question(
    @SerializedName("answer") val answer: List<Answer>,
    @SerializedName("question")val question: String
)