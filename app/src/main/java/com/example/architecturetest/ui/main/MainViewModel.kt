package com.example.architecturetest.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.architecturetest.ui.main.module1.domain.GetDataUseCase
import com.example.architecturetest.ui.main.module1.presentation.viewdata.ViewData
import com.example.architecturetest.ui.main.module1.presentation.viewstate.ViewState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val getDataUseCase: GetDataUseCase) : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    val state = MutableLiveData<ViewState>()

    fun getData() {
        state.value = ViewState.Loading

        compositeDisposable.add(
            getDataUseCase.invoke().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ data ->
                    state.value = ViewState.Ready(ViewData(data.name))
                }, {
                    it.printStackTrace()
                    state.value = ViewState.ViewStateError(it.message.orEmpty())
                }
                )
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}