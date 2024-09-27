package com.example.mvvm_mvi_android_internship.classroom.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.example.mvvm_mvi_android_internship.classroom.domain.model.StudentDomainModel
import com.example.mvvm_mvi_android_internship.classroom.domain.usecase.AddStudentUseCase
import com.example.mvvm_mvi_android_internship.classroom.domain.usecase.ClearStudentsListUseCase
import com.example.mvvm_mvi_android_internship.classroom.domain.usecase.GetStudentsListUseCase
import com.example.mvvm_mvi_android_internship.classroom.presentation.contract.ClassroomContract
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ClassroomMVIViewModel(
    private val getStudentsListUseCase: GetStudentsListUseCase,
    private val addStudentUseCase: AddStudentUseCase,
    private val clearStudentsListUseCase: ClearStudentsListUseCase,
) : BaseViewModel<ClassroomContract.Event, ClassroomContract.State, ClassroomContract.Effect>() {

    override fun setInitialState(): ClassroomContract.State =
        ClassroomContract.State.INITIAL

    override fun handleEvents(event: ClassroomContract.Event) {
        when (event) {
            is ClassroomContract.Event.AddStudentClicked -> {
                addStudent(event.student)
            }

            is ClassroomContract.Event.ClearStudentsListClicked -> {
                clearStudentsList()
            }
        }
    }

    init {
        viewModelScope.launch {
            getStudentsListUseCase.invoke().collect { studentsList ->
                setState { copy(studentsList = studentsList) }
            }
        }
    }

    private fun addStudent(student: StudentDomainModel) {
        setEffect { ClassroomContract.Effect.PrintLog }
        viewModelScope.launch(Dispatchers.Default) {
            addStudentUseCase.invoke(student)
        }
    }

    private fun clearStudentsList() {
        viewModelScope.launch(Dispatchers.Default) {
            clearStudentsListUseCase.invoke()
        }
    }
}