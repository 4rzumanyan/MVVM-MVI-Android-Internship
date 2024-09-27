package com.example.mvvm_mvi_android_internship.classroom.presentation.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mvvm_mvi_android_internship.classroom.domain.model.StudentDomainModel
import com.example.mvvm_mvi_android_internship.classroom.presentation.contract.ClassroomContract
import kotlinx.coroutines.flow.Flow

@Composable
fun ClassroomMVIScreen(
    modifier: Modifier = Modifier,
    state: ClassroomContract.State,
    effect: Flow<ClassroomContract.Effect>,
    onEvent: (ClassroomContract.Event) -> Unit,
) {
    var firstname by remember { mutableStateOf("") }
    var lastname by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        effect.collect { effect ->
            when (effect) {
                ClassroomContract.Effect.PrintLog -> {
                    Log.e("AndroidLogKotlin", "Log is printed")
                }
            }
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(48.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = firstname,
            onValueChange = { changedValue -> firstname = changedValue },
            label = { Text(text = "First Name") })

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = lastname,
            onValueChange = { changedValue -> lastname = changedValue },
            label = { Text(text = "Last Name") })

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = age,
            onValueChange = { changedValue -> age = changedValue },
            label = { Text(text = "Age") })

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onEvent(
                    ClassroomContract.Event.AddStudentClicked(
                        StudentDomainModel(
                            firstname = firstname,
                            lastname = lastname,
                            age = age,
                        )
                    )
                )
            }) {
            Text(text = "Add Student", fontSize = 16.sp)
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onEvent(ClassroomContract.Event.ClearStudentsListClicked)
            }) {
            Text(text = "Clear List", fontSize = 16.sp)
        }

        LazyColumn {
            items(items = state.studentsList) { item ->
                Text(text = "${item.firstname} ${item.lastname} - ${item.age}", fontSize = 16.sp)
            }
        }
    }
}