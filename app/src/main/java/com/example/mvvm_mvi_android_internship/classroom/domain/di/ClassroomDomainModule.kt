package com.example.mvvm_mvi_android_internship.classroom.domain.di

import com.example.mvvm_mvi_android_internship.classroom.domain.usecase.AddStudentUseCase
import com.example.mvvm_mvi_android_internship.classroom.domain.usecase.AddStudentUseCaseImpl
import com.example.mvvm_mvi_android_internship.classroom.domain.usecase.ClearStudentsListUseCase
import com.example.mvvm_mvi_android_internship.classroom.domain.usecase.ClearStudentsListUseCaseImpl
import com.example.mvvm_mvi_android_internship.classroom.domain.usecase.GetStudentsListUseCase
import com.example.mvvm_mvi_android_internship.classroom.domain.usecase.GetStudentsListUseCaseImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val classroomDomainModule = module {
    factoryOf(::GetStudentsListUseCaseImpl) { bind<GetStudentsListUseCase>() }
    factoryOf(::AddStudentUseCaseImpl) { bind<AddStudentUseCase>() }
    factoryOf(::ClearStudentsListUseCaseImpl) { bind<ClearStudentsListUseCase>() }
}