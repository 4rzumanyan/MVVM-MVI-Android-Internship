package com.example.mvvm_mvi_android_internship.classroom.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_mvi_android_internship.classroom.domain.model.StudentDomainModel
import com.example.mvvm_mvi_android_internship.classroom.domain.usecase.AddStudentUseCase
import com.example.mvvm_mvi_android_internship.classroom.domain.usecase.ClearStudentsListUseCase
import com.example.mvvm_mvi_android_internship.classroom.domain.usecase.GetStudentsListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ClassroomMVVMViewModel(
    private val getStudentsListUseCase: GetStudentsListUseCase,
    private val addStudentUseCase: AddStudentUseCase,
    private val clearStudentsListUseCase: ClearStudentsListUseCase,
) : ViewModel() {
    private val _studentsList: MutableStateFlow<List<StudentDomainModel>> =
        MutableStateFlow(emptyList())
    val studentsList = _studentsList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.Default) {
            getStudentsListUseCase.invoke().collect { studentsList ->
                _studentsList.value = studentsList
            }
        }
    }

    fun addStudent(student: StudentDomainModel) {
        viewModelScope.launch(Dispatchers.Default) {
            addStudentUseCase.invoke(student)
        }
    }

    fun clearStudentsList() {
        viewModelScope.launch(Dispatchers.Default) {
            clearStudentsListUseCase.invoke()
        }
    }
}