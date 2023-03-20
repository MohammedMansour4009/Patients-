package com.training.tasktwo.presentation.features.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.training.tasktwo.domain.model.patients.PatientRemoteModel
import com.training.tasktwo.domain.usecase.details.GetPatientByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getPatientByIdUseCase: GetPatientByIdUseCase,
    state: SavedStateHandle
) : ViewModel() {

    private val _detailsStateFlow: MutableStateFlow<PatientRemoteModel?> = MutableStateFlow(null)
    val detailsStateFlow = _detailsStateFlow.asStateFlow()

    private val _detailsLoadingStateFlow: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val detailsLoadingStateFlow = _detailsLoadingStateFlow.asStateFlow()

    private val _detailsErrorStateFlow: MutableStateFlow<Exception?> = MutableStateFlow(null)
    val detailsStateErrorFlow = _detailsErrorStateFlow.asStateFlow()

    private val savedStateHandle = state

    init {
        details()
    }

    fun details() {

        val id = savedStateHandle.get<String>("id")?:"-1"
        viewModelScope.launch {
            _detailsLoadingStateFlow.emit(true)
            try {
                _detailsStateFlow.emit(getPatientByIdUseCase(id))
            } catch (e: Exception) {
                _detailsErrorStateFlow.emit(e)
            }
            _detailsLoadingStateFlow.emit(false)
        }

    }

}