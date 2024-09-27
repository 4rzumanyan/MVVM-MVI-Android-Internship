package com.example.mvvm_mvi_android_internship.classroom.domain.usecase

import com.example.mvvm_mvi_android_internship.classroom.domain.model.StudentDomainModel
import com.example.mvvm_mvi_android_internship.classroom.domain.repository.ClassroomRepository
import kotlinx.coroutines.flow.Flow

interface GetStudentsListUseCase {
    suspend fun invoke(): Flow<List<StudentDomainModel>>
}

class GetStudentsListUseCaseImpl(private val repository: ClassroomRepository) :
    GetStudentsListUseCase {
    override suspend fun invoke(): Flow<List<StudentDomainModel>> = repository.getStudentsList()
}