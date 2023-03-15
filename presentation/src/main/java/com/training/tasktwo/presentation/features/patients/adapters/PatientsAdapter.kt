package com.training.tasktwo.presentation.features.patients.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.training.tasktwo.domain.model.patients.PatientRemoteModel
import com.training.tasktwo.presentation.databinding.RowPatientBinding

class PatientsAdapter : ListAdapter<PatientRemoteModel, PatientsAdapter.PatientsViewHolder>(DiffCallback) {

    var indexLastSelected = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatientsViewHolder {
        val binding = RowPatientBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PatientsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PatientsViewHolder, position: Int) {
        val model = getItem(position)
        holder.bind(model, position)
    }


    inner class PatientsViewHolder(private val binding: RowPatientBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(model: PatientRemoteModel, position: Int) {
            binding.model = model


            binding.cardView.setOnClickListener {
                if (position != indexLastSelected) {

                    // if not default
                    // notify last item
                    if (indexLastSelected != -1) {
                        getItem(position).selected = false
                        notifyItemChanged(indexLastSelected)
                    }

                    // notify new item
                    indexLastSelected = position
                    getItem(position).selected = true
                    notifyItemChanged(position)
                }

            }
        }
    }

    private object DiffCallback : DiffUtil.ItemCallback<PatientRemoteModel>() {

        override fun areItemsTheSame(oldItem: PatientRemoteModel, newItem: PatientRemoteModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: PatientRemoteModel, newItem: PatientRemoteModel): Boolean {
            return oldItem == newItem
        }

    }
}