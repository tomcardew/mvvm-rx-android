package com.example.mvvm_tutorial_2.data.repository

import com.example.mvvm_tutorial_2.data.api.ApiHelper
import com.example.mvvm_tutorial_2.data.model.InstructorResponse
import com.example.mvvm_tutorial_2.data.model.MeResponse
import io.reactivex.Single

class MainRepository(private val helper: ApiHelper) {

    fun getInstructors(): Single<InstructorResponse> {
        return helper.getInstructors()
    }

    fun getMe(): Single<MeResponse> {
        return helper.getMe()
    }

}