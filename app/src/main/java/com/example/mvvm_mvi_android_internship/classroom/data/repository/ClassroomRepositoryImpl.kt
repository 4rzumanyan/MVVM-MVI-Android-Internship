package com.example.mvvm_mvi_android_internship.classroom.data.repository

import com.example.mvvm_mvi_android_internship.classroom.data.helper.ClassroomHelper
import com.example.mvvm_mvi_android_internship.classroom.data.mapper.toDataModel
import com.example.mvvm_mvi_android_internship.classroom.data.mapper.toDomainModel
import com.example.mvvm_mvi_android_internship.classroom.domain.model.StudentDomainModel
import com.example.mvvm_mvi_android_internship.classroom.domain.repository.ClassroomRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class ClassroomRepositoryImpl(private val classroomHelper: ClassroomHelper) : ClassroomRepository {
    override suspend fun getStudentsList(): Flow<List<StudentDomainModel>> =
        withContext(context = Dispatchers.IO) {
            classroomHelper.getStudentList().map { flow -> flow.map { it.toDomainModel() } }
        }

    override suspend fun addStudent(student: StudentDomainModel) = withContext(Dispatchers.IO) {
        classroomHelper.addStudent(student.toDataModel())
    }

    override suspend fun clearStudentsList() = withContext(context = Dispatchers.IO) {
        classroomHelper.clearStudentList()
    }
}