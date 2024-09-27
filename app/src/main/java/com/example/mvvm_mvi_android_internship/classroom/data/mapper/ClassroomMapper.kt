package com.example.mvvm_mvi_android_internship.classroom.data.mapper

import com.example.mvvm_mvi_android_internship.classroom.data.model.StudentDataModel
import com.example.mvvm_mvi_android_internship.classroom.domain.model.StudentDomainModel

fun StudentDomainModel.toDataModel() = StudentDataModel(
    firstname = this.firstname,
    lastname = this.lastname,
    age = this.age.toIntOrNull(),
)

fun StudentDataModel.toDomainModel() = StudentDomainModel(
    firstname = firstname,
    lastname = lastname,
    age = age.toString()
)