package com.example.task_8.presentation

import com.example.task_8.common.BaseViewModel
import com.example.task_8.common.utils.State
import com.example.task_8.data.ItemsDto
import com.example.task_8.model.GetItemsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getItemsUseCase: GetItemsUseCase
) : BaseViewModel() {

    private val _itemsFlow = MutableStateFlow(State<List<ItemsDto>>())
    val itemsFlow get() = _itemsFlow.asStateFlow()

    suspend fun getOutfits() {
        handleResponse(getItemsUseCase(), _itemsFlow.value).collect {
            _itemsFlow.emit(it)
        }
    }

}