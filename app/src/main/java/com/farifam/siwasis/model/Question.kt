package com.farifam.siwasis.model
import com.google.gson.annotations.SerializedName

data class Question(
    @SerializedName("answer") val answer: List<Answer>,
    @SerializedName("question")val question: String,
    var selected_val: Int = 0,
    var confirm_answer: MutableList<String>
)