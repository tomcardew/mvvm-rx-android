package com.example.mvvm_tutorial_2.data.api

import com.example.mvvm_tutorial_2.data.model.Instructor
import com.example.mvvm_tutorial_2.data.model.Response
import io.reactivex.Single

class ApiHelper(private val service: ApiService) {

    fun getInstructors() = service.getInstructors()

    fun getMe() = service.getMe()

}