package com.example.architecturetest.ui.main.module1.domain

import com.example.architecturetest.ui.main.module1.data.api.Services
import com.example.architecturetest.ui.main.module1.entities.BasicData
import io.reactivex.Single

data class GetDataUseCase(private val services: Services) {
    operator fun invoke(): Single<BasicData> = services.getBasicData()
}