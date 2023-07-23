package com.comunidadedevspace.taskbeats.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.comunidadedevspace.taskbeats.Codenotes
import com.comunidadedevspace.taskbeats.data.ProductToSave
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CartTaskDetailViewModel : ViewModel() {
    fun insert(ProductToSave: ProductToSave){
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                Codenotes.getInstance().getAppDataBase().productDao().insert(ProductToSave)
            }
        }


    }

}