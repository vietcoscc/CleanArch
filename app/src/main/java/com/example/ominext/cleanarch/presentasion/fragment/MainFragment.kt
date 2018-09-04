package com.example.ominext.cleanarch.presentasion.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ominext.cleanarch.R
import com.example.ominext.cleanarch.common.di.CleanArchApplication
import com.example.ominext.cleanarch.presentasion.presenter.MainPresenter
import com.example.ominext.cleanarch.presentasion.view.MainView
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

class MainFragment : Fragment(), MainView {
    @Inject
    lateinit var presenter: MainPresenter

    override fun onShowText(message: String) {
        tv?.text = message
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        val cleanArch: CleanArchApplication = activity?.application as CleanArchApplication
        cleanArch.appComponent().inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
    }

    private fun initViews(view: View) {
        presenter.showMessage()
        presenter.showWheather()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}