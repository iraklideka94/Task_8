package com.example.task_8.model

import javax.inject.Inject

class GetItemsUseCase @Inject constructor(
    private val repository: ItemsRepository
) {

    suspend operator fun invoke() = repository.getItems()

}