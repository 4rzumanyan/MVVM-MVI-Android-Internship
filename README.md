# MVVM MVI Android Internship

[![License](https://img.shields.io/badge/License-MIT-blue.svg)](https://opensource.org/licenses/MIT)

This project is teaching material for an Android internship. It is a small "Classroom" app built twice on top of the same data and domain layers, once with MVVM and once with MVI, so the two presentation patterns can be compared side by side.

## Features

- Add a student by entering a first name, last name and age.
- See the student list update automatically as students are added.
- Clear the student list.
- Students are kept in memory only, so the list resets when the app restarts.

## MVVM vs MVI

Both versions use the same screen layout and the same use cases. Only the presentation layer differs.

**MVVM**

- `ClassroomMVVMViewModel` exposes the student list as a `StateFlow` and has public `addStudent()` and `clearStudentsList()` functions.
- `ClassroomMVVMScreen` collects the list and calls those functions directly.

**MVI**

- `ClassroomContract` defines the screen's `Event`s (`AddStudentClicked`, `ClearStudentsListClicked`), a single `State` (the student list) and one-off `Effect`s (`PrintLog`, which writes a log message).
- `BaseViewModel` is a generic MVI base class. It receives events through a `SharedFlow`, updates state with a reducer (`setState`), and sends effects through a `Channel`.
- `ClassroomMVIViewModel` handles each event and updates the state.
- `ClassroomMVIScreen` only receives the state, the effect flow and an `onEvent` callback.

The app shows the MVI screen by default. To run the MVVM version, open `ClassroomMainScreen.kt`, uncomment the `ClassroomMVVMScreen(...)` call and comment out the `ClassroomMVIScreen(...)` call.

## Project Structure

The code is split into clean architecture layers under `app/src/main/java/com/example/mvvm_mvi_android_internship/`:

- `classroom/data` - in-memory student store (`ClassroomHelper`), repository implementation, data models, mappers and Koin module.
- `classroom/domain` - domain model, repository interface, use cases (get, add, clear students) and Koin module.
- `classroom/presentation` - MVI contract, ViewModels, Compose screens and Koin module.
- `common_presentation/theme` - Material 3 theme.
- `FlowOperations.kt` - a short Kotlin Flow example showing `combine` and how `flowOn` changes the dispatcher of upstream operators. The app does not use it.

## Installation

1. Clone the repository: `git clone https://github.com/4rzumanyan/MVVM-MVI-Android-Internship.git`
2. Open the project in Android Studio.
3. Build and run the app on an Android device or emulator (Android 7.0, API 24 or higher).

## Technologies Used

- Android SDK
- Kotlin language (+Gradle)
- Jetpack Compose (Material 3)
- Jetpack ViewModel
- Kotlin Coroutines and Flow
- Koin (dependency injection)

## License

This project is licensed under the [MIT License](LICENSE).
