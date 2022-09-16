package com.example.task_8.data

import com.example.task_8.model.Items


data class ItemsDto(
    val title: String?,
    val cover: String?,
    val price: String?,
    val liked: Boolean?
) {

    fun toItems() = Items(
        title = title,
        cover = cover,
        price = price,
        liked = liked
    )

}