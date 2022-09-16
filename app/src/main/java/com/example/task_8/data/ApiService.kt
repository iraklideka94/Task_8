package com.example.task_8.data

import com.example.task_8.common.ItemApiUtil
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET(ItemApiUtil.END_POINT)
    suspend fun getItems(): Response<List<ItemsDto>>

}