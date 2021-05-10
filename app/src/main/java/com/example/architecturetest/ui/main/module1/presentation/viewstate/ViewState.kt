package com.example.architecturetest.ui.main.module1.presentation.viewstate

import com.example.architecturetest.ui.main.module1.presentation.viewdata.ViewData

sealed class ViewState {
    object Loading : ViewState()
    class ViewStateError(val error:String) : ViewState()
    class Ready(val data : ViewData) : ViewState()
}