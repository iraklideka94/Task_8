package com.example.task_8.data

import com.example.task_8.common.utils.RequestHandler
import com.example.task_8.common.utils.Resource
import com.example.task_8.model.ItemsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ItemsRepositoryImpl @Inject constructor(
    private val api: ApiService
) : ItemsRepository, RequestHandler {

    override suspend fun getItems(): Flow<Resource<List<ItemsDto>>> {
        return safeApiCall { api.getItems() }
    }

}