package com.nikasov.pointscounter.ui.activity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nikasov.pointscounter.data.TableModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    val updateList = MutableLiveData<Boolean>()

    var tableList = ArrayList<TableModel>()

    init {
        addTable()
    }

    fun addTable() {
        val tableModel = TableModel("Миша", 0)
        tableList.add(tableModel)
        updateList.postValue(true)
    }

}