package com.example.mvvm_tutorial_2.data.api

import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.example.mvvm_tutorial_2.data.Constants
import com.example.mvvm_tutorial_2.data.model.InstructorResponse
import com.example.mvvm_tutorial_2.data.model.MeResponse
import io.reactivex.Single
import com.rx2androidnetworking.Rx2AndroidNetworking

class ApiServiceImpl: ApiService {

    override fun getInstructors(): Single<InstructorResponse> {
        return Rx2AndroidNetworking.get(Constants.API_BASE_URL + Constants.CONTEXT.INSTRUCTORS)
            .build()
            .getObjectSingle(InstructorResponse::class.java)
    }

    override fun getMe(): Single<MeResponse> {
        AndroidNetworking.enableLogging()
        return Rx2AndroidNetworking.get(Constants.API_BASE_URL + Constants.CONTEXT.ME)
            .addHeaders("Authorization", "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiI5NWJlY2JlMi0yOGMzLTQ0OGQtOTFhNS0wYThlOTcxZWUxNTAiLCJpYXQiOjE2MzY0MTU0ODksImV4cCI6MTYzNzYyNTA4OX0.WZM46dKXXTvByi_hv_JJ7g45abJpR4WTCe0I0akAgLfCfNQBgj_m7ZMM6LRHpWqVM2zeYIWAQAtjYGFPocHO1Q")
            .build()
            .getObjectSingle(MeResponse::class.java)
    }

}