package com.room.fashion.base

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.room.fashion.util.SnackbarMessage
import com.room.fashion.util.SnackbarMessageString

open class BaseViewModel : ViewModel(){

    // 일회성 이벤트를 만들어 내는 라이브 이벤트
    // 뷰는 이러한 이벤트를 바인딩하고 있다가, 적절한 상황이 되면 액티비티를 호출하거나 스낵바를 만듬
    private val snackbarMessage = SnackbarMessage()
    private val snackbarMessageString = SnackbarMessageString()

    override fun onCleared() {
        super.onCleared()
    }

    /**
     * 스낵바를 보여주고 싶으면 viewModel 에서 이 함수를 호출
     */
    fun showSnackbar(stringResourceId:Int) {
        snackbarMessage.value = stringResourceId
    }
    fun showSnackbar(str:String){
        snackbarMessageString.value = str
    }
    /**
     * BaseKotlinActivity 에서 쓰는 함수
     */
    fun observeSnackbarMessage(lifeCycleOwner: LifecycleOwner, ob:(Int) -> Unit){
        snackbarMessage.observe(lifeCycleOwner, ob)
    }
    fun observeSnackbarMessageStr(lifeCycleOwner: LifecycleOwner, ob:(String) -> Unit) {
        snackbarMessageString.observe(lifeCycleOwner, ob)
    }
}