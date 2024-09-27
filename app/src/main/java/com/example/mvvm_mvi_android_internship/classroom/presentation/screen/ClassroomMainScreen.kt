package com.example.mvvm_mvi_android_internship.classroom.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mvvm_mvi_android_internship.classroom.presentation.viewmodel.ClassroomMVIViewModel
import com.example.mvvm_mvi_android_internship.classroom.presentation.viewmodel.ClassroomMVVMViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun ClassroomMainScreen(modifier: Modifier = Modifier) {
    val mvvmViewModel: ClassroomMVVMViewModel = getViewModel()
    val mviViewModel: ClassroomMVIViewModel = getViewModel()

//    ClassroomMVVMScreen(modifier = modifier, viewmodel = mvvmViewModel)

    ClassroomMVIScreen(
        modifier = modifier,
        state = mviViewModel.viewState.value,
        effect = mviViewModel.effect,
        onEvent = { event -> mviViewModel.setEvent(event) }
    )
}