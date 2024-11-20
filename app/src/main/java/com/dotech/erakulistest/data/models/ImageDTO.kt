package com.dotech.erakulistest.data.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dotech.erakulistest.domain.models.Image
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "image_table")
data class ImageDTO(
    val collections: Int,
    val comments: Int,
    val downloads: Int,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val imageHeight: Int,
    val imageSize: Int,
    val imageWidth: Int,
    val largeImageURL: String,
    val likes: Int,
    val pageURL: String,
    val previewHeight: Int,
    val previewURL: String,
    val previewWidth: Int,
    val tags: String,
    val type: String,
    val user: String,
    val userImageURL: String,
    val user_id: Int,
    val views: Int,
    val webformatHeight: Int,
    val webformatURL: String,
    val webformatWidth: Int
) : Parcelable {
    fun toImage() = Image(
        id = id,
        user = user,
        imageURL = largeImageURL
    )
}
