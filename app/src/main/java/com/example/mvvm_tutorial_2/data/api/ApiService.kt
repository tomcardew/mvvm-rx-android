package com.example.mvvm_tutorial_2.data.api

import com.example.mvvm_tutorial_2.data.model.Instructor
import com.example.mvvm_tutorial_2.data.model.InstructorResponse
import com.example.mvvm_tutorial_2.data.model.MeResponse
import io.reactivex.Single

interface ApiService {

    fun getInstructors(): Single<InstructorResponse>
    fun getMe(): Single<MeResponse>

}