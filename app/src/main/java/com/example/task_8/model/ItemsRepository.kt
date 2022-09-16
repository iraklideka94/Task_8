package com.example.task_8.model

import com.example.task_8.common.utils.Resource
import com.example.task_8.data.ItemsDto
import kotlinx.coroutines.flow.Flow

interface ItemsRepository {

    suspend fun getItems() : Flow<Resource<List<ItemsDto>>>

}