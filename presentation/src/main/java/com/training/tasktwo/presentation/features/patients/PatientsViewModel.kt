package com.training.tasktwo.presentation.features.patients

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.training.tasktwo.domain.model.delete.PatientDeleteResponseModel
import com.training.tasktwo.domain.model.patients.PatientRemoteModel
import com.training.tasktwo.domain.usecase.delete.DeletePatientUseCase
import com.training.tasktwo.domain.usecase.patients.GetPatientsSortedByNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PatientsViewModel @Inject constructor(
    private val getPatientsSortedByNameUseCase: GetPatientsSortedByNameUseCase,
    private val deletePatientUseCase: DeletePatientUseCase
) : ViewModel() {

    private val _patientsStateFlow: MutableStateFlow<List<PatientRemoteModel>> = MutableStateFlow(emptyList())
    val patientsStateFlow = _patientsStateFlow.asStateFlow()

    private val _deletePatientLiveData: MutableLiveData<PatientDeleteResponseModel> = MutableLiveData()
    val deletePatientLiveData: LiveData<PatientDeleteResponseModel> = _deletePatientLiveData

    private val _patientsLoadingStateFlow: MutableStateFlow<Boolean> = MutableStateFlow(true)
    val patientsLoadingStateFlow = _patientsLoadingStateFlow.asStateFlow()

    private val _patientsErrorStateFlow: MutableStateFlow<Exception?> = MutableStateFlow(null)
    val patientsStateErrorFlow = _patientsErrorStateFlow.asStateFlow()


    init {
        getPatients()
    }

    fun getPatients() {
        viewModelScope.launch {
            _patientsLoadingStateFlow.emit(true)
            try {
                _patientsStateFlow.emit(getPatientsSortedByNameUseCase())
            } catch (e: Exception) {
                _patientsErrorStateFlow.emit(e)
            }
            _patientsLoadingStateFlow.emit(false)
        }
    }

    fun deletePatient(id: String) {
        viewModelScope.launch {
            _patientsLoadingStateFlow.emit(true)
            try {
                _deletePatientLiveData.postValue(deletePatientUseCase(id)!!)
            } catch (e: Exception) {
                _patientsErrorStateFlow.emit(e)
            }
            _patientsLoadingStateFlow.emit(false)
        }
    }


}