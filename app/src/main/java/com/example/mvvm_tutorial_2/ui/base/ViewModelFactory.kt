package com.example.mvvm_tutorial_2.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_tutorial_2.data.api.ApiHelper
import com.example.mvvm_tutorial_2.data.repository.MainRepository
import com.example.mvvm_tutorial_2.fragments.profile_summary.viewmodel.ProfileSummaryViewModel
import com.example.mvvm_tutorial_2.ui.main.viewmodel.MainViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(private val helper: ApiHelper): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(MainRepository(helper)) as T
        } else if (modelClass.isAssignableFrom(ProfileSummaryViewModel::class.java)) {
            return ProfileSummaryViewModel(MainRepository(helper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}