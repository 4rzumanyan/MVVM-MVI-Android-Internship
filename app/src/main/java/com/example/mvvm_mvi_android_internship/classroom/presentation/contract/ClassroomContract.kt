package com.example.mvvm_mvi_android_internship.classroom.presentation.contract

import com.example.mvvm_mvi_android_internship.classroom.domain.model.StudentDomainModel
import com.example.mvvm_mvi_android_internship.classroom.presentation.viewmodel.ViewEffect
import com.example.mvvm_mvi_android_internship.classroom.presentation.viewmodel.ViewEvent
import com.example.mvvm_mvi_android_internship.classroom.presentation.viewmodel.ViewState

class ClassroomContract {
    sealed class Event : ViewEvent {
        data class AddStudentClicked(val student: StudentDomainModel) : Event()
        data object ClearStudentsListClicked : Event()
    }

    data class State(val studentsList: List<StudentDomainModel>) : ViewState {
        companion object {
            val INITIAL = State(
                studentsList = emptyList()
            )
        }
    }

    sealed class Effect : ViewEffect {
        // Something like navigation
        data object PrintLog : Effect()
    }
}