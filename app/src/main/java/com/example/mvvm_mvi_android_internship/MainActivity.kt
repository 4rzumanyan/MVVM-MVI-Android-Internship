package com.example.mvvm_mvi_android_internship

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.mvvm_mvi_android_internship.classroom.presentation.screen.ClassroomMainScreen
import com.example.mvvm_mvi_android_internship.common_presentation.theme.MVVMMVIAndroidInternshipTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MVVMMVIAndroidInternshipTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ClassroomMainScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}