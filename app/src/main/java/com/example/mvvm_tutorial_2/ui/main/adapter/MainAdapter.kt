package com.example.mvvm_tutorial_2.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import com.example.mvvm_tutorial_2.data.model.Instructor

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvm_tutorial_2.R
import kotlinx.android.synthetic.main.item_layout.view.*

class MainAdapter(
    private val instructors: ArrayList<Instructor>
) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(instructor: Instructor) {
            itemView.textViewName.text = instructor.name + " " + instructor.lastname
            Glide.with(itemView.imageViewAvatar.context)
                .load(instructor.profilePicture)
                .into(itemView.imageViewAvatar)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DataViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
    )

    override fun getItemCount(): Int = instructors.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) = holder.bind(instructors[position])

    fun addData(list: List<Instructor>) {
        instructors.addAll(list)
    }

}