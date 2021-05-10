package com.example.architecturetest.ui.main.module1.data.api

import com.google.gson.annotations.SerializedName

data class BasicResponse(
   @SerializedName("entries") private val entries : List<Entry>
)