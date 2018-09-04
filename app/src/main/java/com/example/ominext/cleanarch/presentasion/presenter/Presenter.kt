package com.example.ominext.cleanarch.presentasion.presenter

import com.example.ominext.cleanarch.presentasion.view.BaseView

interface Presenter<T : BaseView> {
    fun attachView(view: T)
    fun detachView()
}