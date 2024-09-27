package com.example.mvvm_mvi_android_internship.classroom.data.di

import org.koin.core.module.dsl.singleOf
import com.example.mvvm_mvi_android_internship.classroom.data.helper.ClassroomHelper
import com.example.mvvm_mvi_android_internship.classroom.domain.repository.ClassroomRepository
import com.example.mvvm_mvi_android_internship.classroom.data.repository.ClassroomRepositoryImpl
import org.koin.core.module.dsl.bind
import org.koin.dsl.module

val classroomDataModule = module {
    singleOf(::ClassroomHelper)
    singleOf(::ClassroomRepositoryImpl) { bind<ClassroomRepository>() }
}
