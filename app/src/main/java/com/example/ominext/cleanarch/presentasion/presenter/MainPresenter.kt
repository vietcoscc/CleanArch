package com.example.ominext.cleanarch.presentasion.presenter

import com.example.ominext.cleanarch.domain.usecase.main.GetMessageUseCase
import com.example.ominext.cleanarch.domain.usecase.main.GetWeatherUseCase
import com.example.ominext.cleanarch.presentasion.view.MainView
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainPresenter @Inject constructor() : Presenter<MainView> {
    private var view: MainView? = null
    @Inject
    lateinit var getMessageUseCase: GetMessageUseCase
    @Inject
    lateinit var getWeatherUseCase: GetWeatherUseCase

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    override fun attachView(view: MainView) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }

    fun showMessage() {
        val text = getMessageUseCase.exe("Nguyễn Quốc Việt")
        view?.onShowText(text)
    }

    fun showWheather() {
        getWeatherUseCase.exe().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    view?.onShowText(it.toString())
                }
    }
}