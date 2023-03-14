package com.training.tasktwo.presentation.features.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.training.tasktwo.domain.model.AddPatientRemoteModel
import com.training.tasktwo.domain.model.add.BodyAddPatientModel
import com.training.tasktwo.domain.usecase.add.AddPatientUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddPatientViewModel @Inject constructor(
    private val addPatientUseCase: AddPatientUseCase
) : ViewModel() {

    private val _addPatientStateFlow: MutableStateFlow<AddPatientRemoteModel?> = MutableStateFlow(null)
    val addPatientStateFlow = _addPatientStateFlow.asStateFlow()

    private val _addPatientLoadingStateFlow: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val addPatientLoadingStateFlow = _addPatientLoadingStateFlow.asStateFlow()

    private val _addPatientErrorStateFlow: MutableStateFlow<Exception?> = MutableStateFlow(null)
    val addPatientStateErrorFlow = _addPatientErrorStateFlow.asStateFlow()

    fun addPatient(bodyAddPatientModel: BodyAddPatientModel) {
        viewModelScope.launch {
            _addPatientLoadingStateFlow.emit(true)
            try {
                _addPatientStateFlow.emit(addPatientUseCase(bodyAddPatientModel))
            } catch (e: Exception) {
                _addPatientErrorStateFlow.emit(e)
            }
            _addPatientLoadingStateFlow.emit(false)
        }

    }

}