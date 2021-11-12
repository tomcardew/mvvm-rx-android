package com.example.mvvm_tutorial_2.fragments.profile_summary.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvm_tutorial_2.data.model.MeResponse
import com.example.mvvm_tutorial_2.data.repository.MainRepository
import com.example.mvvm_tutorial_2.utils.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ProfileSummaryViewModel(private val mainRepository: MainRepository): ViewModel() {

    private val me = MutableLiveData<Resource<MeResponse>>()
    private val compositeDisposable = CompositeDisposable()

    init {
        fetchMe()
    }

    private fun fetchMe() {
        me.postValue(Resource.loading(null))
        compositeDisposable.add(
            mainRepository.getMe()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ meResponse ->
                    me.postValue(Resource.success(meResponse))
                }, { throwable ->
                    Log.d("ERRROR", throwable.stackTraceToString())
                    me.postValue(Resource.error("Couldn't load your profile", null))
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun getMe(): LiveData<Resource<MeResponse>> {
        return me
    }

}