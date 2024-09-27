package com.example.mvvm_mvi_android_internship.classroom.presentation.screen

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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mvvm_mvi_android_internship.classroom.domain.model.StudentDomainModel
import com.example.mvvm_mvi_android_internship.classroom.presentation.viewmodel.ClassroomMVVMViewModel

@Composable
fun ClassroomMVVMScreen(
    modifier: Modifier = Modifier,
    viewmodel: ClassroomMVVMViewModel,
) {
    val studentsList = viewmodel.studentsList.collectAsState()

    var firstname by remember { mutableStateOf("") }
    var lastname by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }

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
                viewmodel.addStudent(
                    StudentDomainModel(firstname = firstname, lastname = lastname, age = age)
                )
            }) {
            Text(text = "Add Student", fontSize = 16.sp)
        }

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                viewmodel.clearStudentsList()
            }) {
            Text(text = "Clear List", fontSize = 16.sp)
        }

        LazyColumn {
            items(items = studentsList.value) { item ->
                Text(text = "${item.firstname} ${item.lastname} - ${item.age}", fontSize = 16.sp)
            }
        }
    }
}