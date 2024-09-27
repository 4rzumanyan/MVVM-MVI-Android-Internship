package com.example.mvvm_mvi_android_internship.classroom.presentation.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import com.example.mvvm_mvi_android_internship.classroom.presentation.viewmodel.ClassroomMVVMViewModel
import com.example.mvvm_mvi_android_internship.classroom.presentation.viewmodel.ClassroomMVIViewModel
import org.koin.dsl.module

val classroomPresentationModule = module {
    viewModelOf(::ClassroomMVVMViewModel)
    viewModelOf(::ClassroomMVIViewModel)
}