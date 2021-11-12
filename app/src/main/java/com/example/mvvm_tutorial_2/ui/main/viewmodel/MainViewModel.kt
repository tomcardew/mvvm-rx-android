package com.example.mvvm_tutorial_2.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_tutorial_2.data.model.InstructorResponse
import com.example.mvvm_tutorial_2.data.repository.MainRepository
import com.example.mvvm_tutorial_2.utils.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val mainRepository: MainRepository): ViewModel() {

    private val instructors = MutableLiveData<Resource<InstructorResponse>>()
    private val compositeDisposable = CompositeDisposable()

    init {
        fetchInstructors()
    }

    private fun fetchInstructors() {
        instructors.postValue(Resource.loading(null))
        compositeDisposable.add(
            mainRepository.getInstructors()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ instructorList ->
                    instructors.postValue(Resource.success(instructorList))
                }, { throwable ->
                    instructors.postValue(Resource.error("Something went wrong", null))
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun getInstructors(): LiveData<Resource<InstructorResponse>> {
        return instructors
    }

}