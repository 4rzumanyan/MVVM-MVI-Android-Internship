package com.example.mvvm_mvi_android_internship.classroom.domain.usecase

import com.example.mvvm_mvi_android_internship.classroom.domain.model.StudentDomainModel
import com.example.mvvm_mvi_android_internship.classroom.domain.repository.ClassroomRepository

interface AddStudentUseCase {
    suspend fun invoke(student: StudentDomainModel)
}

class AddStudentUseCaseImpl(private val repository: ClassroomRepository) : AddStudentUseCase {
    override suspend fun invoke(student: StudentDomainModel) = repository.addStudent(student)
}