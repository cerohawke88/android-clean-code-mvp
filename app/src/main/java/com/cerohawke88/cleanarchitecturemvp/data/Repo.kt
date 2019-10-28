package com.cerohawke88.cleanarchitecturemvp.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Repo(
    @Expose @SerializedName("author") val author: String,
    @Expose @SerializedName("name") val name: String,
    @Expose @SerializedName("url") val url: String,
    @Expose @SerializedName("description") val description: String,
    @Expose @SerializedName("stars") val stars: Int,
    @Expose @SerializedName("forks") val forks: Int,
    @Expose @SerializedName("currentPeriodStars") val currentPeriodStars: Int,
    @Expose @SerializedName("avatar") val avatar: String,
    @Expose @SerializedName("language") val language: String?,
    @Expose @SerializedName("languageColor") val languageColor: String?
) {
    private var expanded: Boolean = false

    fun isExpanded():Boolean {
        return expanded
    }

    fun setExpanded(value:Boolean){
        expanded = value
    }
}