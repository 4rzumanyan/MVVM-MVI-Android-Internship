package com.example.mvvm_mvi_android_internship.classroom.data.helper

import com.example.mvvm_mvi_android_internship.classroom.data.model.StudentDataModel
import kotlinx.coroutines.flow.MutableStateFlow

class ClassroomHelper {
    private val _studentList: MutableStateFlow<List<StudentDataModel>> =
        MutableStateFlow(emptyList())

    fun getStudentList(): MutableStateFlow<List<StudentDataModel>> {
        return _studentList
    }

    fun addStudent(student: StudentDataModel) {
        _studentList.value = _studentList.value.plus(student)
    }

    fun clearStudentList() {
        _studentList.value = emptyList()
    }
}