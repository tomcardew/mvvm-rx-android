package com.example.mvvm_tutorial_2.fragments.profile_summary.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.mvvm_tutorial_2.R
import com.example.mvvm_tutorial_2.data.api.ApiHelper
import com.example.mvvm_tutorial_2.data.api.ApiServiceImpl
import com.example.mvvm_tutorial_2.data.model.User
import com.example.mvvm_tutorial_2.fragments.profile_summary.viewmodel.ProfileSummaryViewModel
import com.example.mvvm_tutorial_2.ui.base.ViewModelFactory
import com.example.mvvm_tutorial_2.utils.Status
import kotlinx.android.synthetic.main.profile_summary_fragment.*

class ProfileSummary: Fragment() {

    private val TAG = "ProfileSummary_Fragment"
    private lateinit var viewModel: ProfileSummaryViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.profile_summary_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        setupObserver()
    }

    private fun setupObserver() {
        Log.d(TAG, "Setup observer")
        viewModel.getMe().observeForever {
            when(it.status) {
                Status.SUCCESS -> {
                    it.data?.let { response -> response.data?.let { data -> data.profile?.let { user -> render(user) } } }
                }
                Status.ERROR -> {
                    Toast.makeText(this.context, it.message, Toast.LENGTH_SHORT).show()
                    Log.d(TAG, it.data.toString())
                }
                Status.LOADING -> {
                    Log.d("ProfileSummary", "Loading")
                }
            }
        }
    }

    private fun render(me: User) {
        textViewName.text = me.name + " " + me.lastname
        textViewEmail.text = me.email
        Glide.with(imageViewAvatar.context).load(me.pictureUrl).into(imageViewAvatar)
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, ViewModelFactory(ApiHelper((ApiServiceImpl())))).get(ProfileSummaryViewModel::class.java)
    }

}