package com.example.mvvm_mvi_android_internship

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart

val a = flowOf(1, 2, 3, 4)
val b = flowOf(5, 6, 7, 8)
val c = a.combine(b) { a, b -> a + b }

suspend fun collectA() {
    a.onEach { } //Dispatcher IO
        .catch { } //Dispatcher IO
        .flowOn(Dispatchers.IO)
        .onStart { } //Dispatcher Main
        .onCompletion { } //Dispatcher Main
        .flowOn(Dispatchers.Main)
        .collect()
}