package com.example.ominext.cleanarch.domain.usecase.main

import com.example.ominext.cleanarch.domain.repository.MainRepos
import javax.inject.Inject

class GetMessageUseCase @Inject constructor() {
    @Inject
    lateinit var mainRepos: MainRepos

    fun exe(message: String): String {
        return mainRepos.getMessage(message)
    }
}