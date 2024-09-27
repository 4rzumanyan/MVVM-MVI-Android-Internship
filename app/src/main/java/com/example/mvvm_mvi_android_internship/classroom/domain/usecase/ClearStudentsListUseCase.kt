package com.example.mvvm_mvi_android_internship.classroom.domain.usecase

import com.example.mvvm_mvi_android_internship.classroom.domain.repository.ClassroomRepository

interface ClearStudentsListUseCase {
    suspend fun invoke()
}

class ClearStudentsListUseCaseImpl(private val repository: ClassroomRepository) :
    ClearStudentsListUseCase {
    override suspend fun invoke() = repository.clearStudentsList()
}