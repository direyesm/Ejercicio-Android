package com.example.moofwd_app.viewModel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moofwd_app.entities.ItemEnti
import com.example.moofwd_app.repository.Repository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.net.URL

class ItemViewModel: ViewModel() {

    var items: MutableLiveData<MutableList<ItemEnti>> = MutableLiveData()

    fun init (context: Context){
        if (items.value != null)
            return
    }

    private val repo = Repository()
    fun fetchData(): MutableLiveData<MutableList<ItemEnti>> {
        viewModelScope.launch(IO) {
            items.postValue(repo.getEvents())
        }
        return  items
    }

    fun fetchDetails(): MutableLiveData<MutableList<ItemEnti>> {
        val item = MutableLiveData<MutableList<ItemEnti>>()
        viewModelScope.launch(IO) {
            item.postValue(repo.getEvents())
        }
        return  item
    }
}