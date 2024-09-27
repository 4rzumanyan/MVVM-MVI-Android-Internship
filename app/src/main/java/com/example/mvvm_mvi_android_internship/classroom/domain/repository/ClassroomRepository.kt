package com.example.mvvm_mvi_android_internship.classroom.domain.repository

import com.example.mvvm_mvi_android_internship.classroom.domain.model.StudentDomainModel
import kotlinx.coroutines.flow.Flow

interface ClassroomRepository {
    suspend fun getStudentsList(): Flow<List<StudentDomainModel>>
    suspend fun addStudent(student: StudentDomainModel)
    suspend fun clearStudentsList()
}