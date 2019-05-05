package com.farifam.siwasis.model
import com.google.gson.annotations.SerializedName

data class Answer(
    @SerializedName("action") val action: String,
    @SerializedName("label") val label: String,
    @SerializedName("message") val message: List<Any>,
    @SerializedName("next_action") val next_action: Question?
)