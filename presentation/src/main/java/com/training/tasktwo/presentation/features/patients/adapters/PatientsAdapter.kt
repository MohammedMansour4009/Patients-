package com.training.tasktwo.presentation.features.patients.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.training.tasktwo.domain.model.patients.PatientRemoteModel
import com.training.tasktwo.presentation.databinding.RowPatientBinding

class PatientsAdapter(private val patients: List<PatientRemoteModel>) :
    RecyclerView.Adapter<PatientsAdapter.PatientsViewHolder>() {


    var indexLastSelected = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatientsViewHolder {
        val binding = RowPatientBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PatientsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PatientsViewHolder, position: Int) {
        val model = patients[position]
        holder.bind(model, position)
    }

    override fun getItemCount(): Int {
        return patients.size
    }

    inner class PatientsViewHolder(private val binding: RowPatientBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(model: PatientRemoteModel, position: Int) {
            binding.model = model


            binding.cardView.setOnClickListener {
                if (position != indexLastSelected) {

                    // if not default
                    // notify last item
                    if (indexLastSelected != -1) {
                        patients[indexLastSelected].selected = false
                        notifyItemChanged(indexLastSelected)
                    }

                    // notify new item
                    indexLastSelected = position
                    patients[position].selected = true
                    notifyItemChanged(position)
                }

            }
        }
    }
}