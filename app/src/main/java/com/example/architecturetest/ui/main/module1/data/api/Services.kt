package com.example.architecturetest.ui.main.module1.data.api

import com.example.architecturetest.ui.main.module1.entities.BasicData
import io.reactivex.Single
import retrofit2.http.GET

interface Services {
    @GET
    fun getBasicData(): Single<BasicData>
}