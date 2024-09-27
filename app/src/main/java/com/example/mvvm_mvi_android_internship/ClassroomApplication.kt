package com.example.mvvm_mvi_android_internship

import android.app.Application
import com.example.mvvm_mvi_android_internship.classroom.data.di.classroomDataModule
import com.example.mvvm_mvi_android_internship.classroom.domain.di.classroomDomainModule
import com.example.mvvm_mvi_android_internship.classroom.presentation.di.classroomPresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class ClassroomApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@ClassroomApplication)
            modules(classroomDataModule, classroomDomainModule, classroomPresentationModule)
        }
    }
}