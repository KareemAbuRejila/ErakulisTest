package com.dotech.erakulistest.domain.models

import com.google.gson.annotations.SerializedName


data class Image(
    @SerializedName("id")
    val id: Int,

    @SerializedName("user")
    val user: String,

    @SerializedName("webformatURL")
    val imageURL: String
){
    fun compare(image: Image) = when{
        this == image -> true
        id != image.id -> false
        user !=image.user -> false
        imageURL != image.imageURL -> false
        else -> true
    }
}
