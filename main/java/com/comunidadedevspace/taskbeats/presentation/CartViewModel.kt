package com.comunidadedevspace.taskbeats.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.comunidadedevspace.taskbeats.Codenotes
import com.comunidadedevspace.taskbeats.data.ProductToSave
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CartViewModel: ViewModel() {
    val listLiveData = MutableLiveData<List<ProductToSave>>()
    fun getAll(){
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val list = Codenotes.getInstance().getAppDataBase().productDao().getAll()
                listLiveData.postValue(list)
            }
        }


    }
    fun delete(ProductToSave: ProductToSave){
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
               Codenotes.getInstance().getAppDataBase().productDao().deleteById(ProductToSave)
               getAll()
            }
        }
    }
}